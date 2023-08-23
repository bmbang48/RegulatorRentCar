-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 23, 2023 at 02:16 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama`, `username`, `password`) VALUES
(1, 'admin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `mobil`
--

CREATE TABLE `mobil` (
  `no_plat` varchar(10) NOT NULL,
  `merk` varchar(10) NOT NULL,
  `type` varchar(10) NOT NULL,
  `tahun` int(4) NOT NULL,
  `jumlah_penumpang` int(3) NOT NULL,
  `kekuatan_mesin` int(5) NOT NULL,
  `konsumsi_bbm` int(3) NOT NULL,
  `kecepatan_maksimum` int(5) NOT NULL,
  `transmisi` varchar(20) NOT NULL,
  `harga` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  `preferensi` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mobil`
--

INSERT INTO `mobil` (`no_plat`, `merk`, `type`, `tahun`, `jumlah_penumpang`, `kekuatan_mesin`, `konsumsi_bbm`, `kecepatan_maksimum`, `transmisi`, `harga`, `status`, `preferensi`) VALUES
('B 1053 DFO', 'Toyota', 'Innova', 2022, 8, 2000, 13, 200, 'Automatic', 600000, 'Tidak Tersedia', 0.605629672524575),
('B 2145 SFZ', 'Toyota', 'Avanza', 2015, 8, 1500, 13, 170, 'Automatic', 400000, 'Tidak Tersedia', 0.620555027665235),
('B 2653 SZT', 'Honda', 'Mobilio', 2018, 7, 1500, 18, 150, 'Automatic', 400000, 'Tidak Tersedia', 0.6129893767777892),
('B 3142 SGE', 'Toyota', 'Alphard', 2017, 6, 2400, 11, 200, 'Automatic', 1300000, 'Tidak Tersedia', 0.39185836662606593),
('B 5428 PBG', 'Toyota', 'Camry', 2016, 4, 2500, 10, 210, 'Automatic', 1200000, 'Tidak Tersedia', 0.3797434930236958),
('D 482 HG', 'Toyota', 'Hi-Ace', 2016, 16, 2500, 9, 155, 'Automatic', 2300000, 'Tidak Tersedia', 0.45208777217659923);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `nik` varchar(25) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `foto_ktp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`nik`, `nama`, `alamat`, `telp`, `email`, `foto_ktp`) VALUES
('123094839482', 'Pelanggan 5', 'Jln. Kebayoran baru No.2e', '089482921382', 'pelanggan5@gmail.com', 'src\\upload\\123094839482.jpeg'),
('12341243421', 'Pelanggan 3', 'Jl. Mampang Prapatan VII', '08937162843', 'pelanggan3@gmail.com', 'src\\upload\\12341243421.jpg'),
('20179273202', 'Pelanggan 8', 'Jl. Kuningan Barat 2 No.42', '08921827323', 'pelanggan8@gmail.com', 'src\\upload\\20179273202.jpeg'),
('293810848201', 'Pelanggan 4', 'Jln. Buncit Raya ', '08927312837', 'pelanggan4@gmail.com', 'src\\upload\\293810848201.jpg'),
('3124566758764323', 'Pelanggan 1', 'Jl. Mampang Prapatan XVII No.40', '089898787662', 'Pelanggan21@gmail.com', 'src\\upload\\3124566758764323.jpg'),
('3145679976621', 'Pelanggan 2', 'Jl. Bangka 2', '089928392841', 'pelanggan2@gmail.com', 'src\\upload\\3145679976621(1).jpg'),
('3197384698137', 'Pelanggan 10', 'Jl. Pancoran Barat 3 No.12', '08938748238', 'pelanggan10@gmail.com', 'src\\upload\\3197384698137.jpg'),
('32418289372', 'Pelanggan 7', 'Jl. Pondok Jaya 2 No.31', '085727138492', 'pelanggan7@gmail.com', 'src\\upload\\32418289372.jpg'),
('38167836481314', 'Pelanggan 6', 'Jl.Mampang Prapatan IX No. 99', '089273842973', 'pelanggan6@gmail.com', 'src\\upload\\38167836481314.jpg'),
('38838462947859', 'Pelanggan 9', 'Jl. Pondok Karya No.32	', '08974913922', 'pelanggan9@gmail.com', 'src\\upload\\38838462947859.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `pinjam`
--

CREATE TABLE `pinjam` (
  `id_transaksi` varchar(10) NOT NULL,
  `nik` varchar(25) NOT NULL,
  `no_plat` varchar(10) NOT NULL,
  `tgl_pinjam` varchar(15) NOT NULL,
  `tgl_kembali` varchar(15) NOT NULL,
  `lama_pinjam` int(3) NOT NULL,
  `total` int(11) NOT NULL,
  `bayar` int(11) NOT NULL DEFAULT 0,
  `overtime` int(3) NOT NULL DEFAULT 0,
  `denda` int(11) NOT NULL DEFAULT 0,
  `id_supir` varchar(20) DEFAULT 'Tanpa Supir',
  `status_transaksi` varchar(20) DEFAULT 'Berjalan'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pinjam`
--

INSERT INTO `pinjam` (`id_transaksi`, `nik`, `no_plat`, `tgl_pinjam`, `tgl_kembali`, `lama_pinjam`, `total`, `bayar`, `overtime`, `denda`, `id_supir`, `status_transaksi`) VALUES
('T00001', '3124566758764323', 'B 1053 DFO', '18-07-2023', '19-07-2023', 2, 1900000, 1900000, 0, 0, '301924230384', 'Selesai'),
('T00003', '3124566758764323', 'B 5428 PBG', '21-07-2023', '25-07-2023', 5, 7500000, 0, 0, 0, '3212442425', 'Berjalan'),
('T00005', '12341243421', 'B 1053 DFO', '21-07-2023', '22-07-2023', 2, 1800000, 0, 0, 0, '2394849212934', 'Berjalan'),
('T00006', '293810848201', 'B 2653 SZT', '22-07-2023', '24-07-2023', 3, 2250000, 0, 0, 0, '301924230384', 'Berjalan'),
('T00007', '3197384698137', 'B 2145 SFZ', '20-07-2023', '21-07-2023', 2, 1300000, 0, 0, 0, '3948291739281', 'Berjalan'),
('T00008', '38838462947859', 'B 3142 SGE', '26-12-2023', '26-12-2023', 1, 1650000, 0, 0, 0, '321568689563', 'Berjalan'),
('T00009', '3197384698137', 'D 482 HG', '21-07-2023', '21-07-2023', 1, 2650000, 0, 0, 0, '30940294810293', 'Berjalan');

-- --------------------------------------------------------

--
-- Table structure for table `supir`
--

CREATE TABLE `supir` (
  `id_supir` varchar(20) NOT NULL,
  `nama_supir` varchar(30) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `biaya` int(11) NOT NULL,
  `foto_sim` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supir`
--

INSERT INTO `supir` (`id_supir`, `nama_supir`, `telp`, `alamat`, `biaya`, `foto_sim`) VALUES
('2394849212934', 'Waston Azizi', '08937182944', 'Jl. Mampang Prapatan VII No. 75', 300000, 'src\\upload\\2394849212934.jpg'),
('29183901283', 'Warsito', '08937168472', 'Jl. Kebon Jeruk No.30', 300000, 'src\\upload\\29183901283.jpeg'),
('301924230384', 'Ringo Latoni', '081237743218', 'Jl. Mampang Prapatan XIII', 350000, 'src\\upload\\301924230384.jpg'),
('30391829444201', 'Heri Subangun', '083084192834', 'Jl. Bangka 9 No.3a', 300000, 'src\\upload\\30391829444201.jpg'),
('30940294810293', 'Moch Zakaria', '085938192834', 'Jl. Mampang Prapatan XII', 350000, 'src\\upload\\30940294810293(1).jpg'),
('3212442425', 'Abryansyah', '08373821232', 'Jl. Mampang Prapatan V', 300000, '333'),
('321568689563', 'Muhammad Reza', '083927297163', 'Jl. Mampang Prapatan VII', 350000, 'src\\upload\\321568689563.jpg'),
('3219283948291', 'Heri Zakarias', '089738172373', 'Bogor Cibinong', 300000, 'src\\upload\\3219283948291(1).png'),
('3918372947292', 'Abu Stengky', '08937281234', 'Jl. Mampang Prapatan V No 83', 250000, 'src\\upload\\3918372947292.jpg'),
('3948291739281', 'Arif Rachman', '08921829389', 'Jl. Tegal Parang No.43', 250000, 'src\\upload\\3948291739281.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`no_plat`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `pinjam`
--
ALTER TABLE `pinjam`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `nik` (`nik`),
  ADD KEY `no_plat` (`no_plat`),
  ADD KEY `id_supir` (`id_supir`);

--
-- Indexes for table `supir`
--
ALTER TABLE `supir`
  ADD PRIMARY KEY (`id_supir`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pinjam`
--
ALTER TABLE `pinjam`
  ADD CONSTRAINT `pinjam_ibfk_1` FOREIGN KEY (`nik`) REFERENCES `pelanggan` (`nik`),
  ADD CONSTRAINT `pinjam_ibfk_2` FOREIGN KEY (`no_plat`) REFERENCES `mobil` (`no_plat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
