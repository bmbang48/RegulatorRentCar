/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2023 Cloud Software Group, Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.customvisualization.export;

import java.awt.Graphics2D;

import net.sf.jasperreports.engine.JRGenericPrintElement;
import net.sf.jasperreports.engine.export.GenericElementGraphics2DHandler;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterContext;
import net.sf.jasperreports.engine.export.draw.ImageDrawer;
import net.sf.jasperreports.engine.export.draw.Offset;
import net.sf.jasperreports.repo.RepositoryContext;

/**
 * @author Giulio Toffoli (gt78@users.sourceforge.net)
 */
public class CVElementGraphics2DHandler implements GenericElementGraphics2DHandler
{
	private static final CVElementGraphics2DHandler INSTANCE = new CVElementGraphics2DHandler();

	public static CVElementGraphics2DHandler getInstance()
	{
		return INSTANCE;
	}

	@Override
	public void exportElement(
		JRGraphics2DExporterContext exporterContext,
		JRGenericPrintElement element,
		Graphics2D grx,
		Offset offset
		)
	{
		try
		{
			JRGraphics2DExporter exporter = (JRGraphics2DExporter) exporterContext.getExporterRef();
			ImageDrawer imageDrawer = exporter.getDrawVisitor().getImageDrawer();

			RepositoryContext repositoryContext = exporterContext.getRepository().getRepositoryContext();
			imageDrawer.draw(
				grx,
				CVElementImageProvider.getInstance().getImage(repositoryContext, element),
				offset.getX(),
				offset.getY()
				);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean toExport(JRGenericPrintElement element)
	{
		return true;
	}
}
