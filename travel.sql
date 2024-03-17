-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.22-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for travel
CREATE DATABASE IF NOT EXISTS `travel` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `travel`;

-- Dumping structure for table travel.kendaraan
CREATE TABLE IF NOT EXISTS `kendaraan` (
  `plat` varchar(10) NOT NULL,
  `jenis` varchar(30) NOT NULL,
  `status` varchar(12) NOT NULL,
  PRIMARY KEY (`plat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table travel.pelanggan
CREATE TABLE IF NOT EXISTS `pelanggan` (
  `id_pel` int(6) NOT NULL AUTO_INCREMENT,
  `nama_pel` varchar(20) NOT NULL,
  `no_telp` varchar(15) NOT NULL,
  `asal` varchar(15) NOT NULL,
  PRIMARY KEY (`id_pel`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table travel.pesan
CREATE TABLE IF NOT EXISTS `pesan` (
  `id_pel` int(6) NOT NULL,
  `id_wisata` int(6) NOT NULL,
  `id_ptgs` int(6) NOT NULL,
  `plat` varchar(10) NOT NULL,
  `biaya` int(7) NOT NULL,
  `tanggal` date NOT NULL,
  `no_pesan` int(6) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`no_pesan`),
  KEY `id_pel` (`id_pel`),
  KEY `id_wisata` (`id_wisata`),
  KEY `id_ptgs` (`id_ptgs`),
  KEY `plat` (`plat`),
  CONSTRAINT `fk_pesan_idpel` FOREIGN KEY (`id_pel`) REFERENCES `pelanggan` (`id_pel`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pesan_idptgs` FOREIGN KEY (`id_ptgs`) REFERENCES `petugas` (`id_ptgs`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pesan_idwisata` FOREIGN KEY (`id_wisata`) REFERENCES `wisata` (`id_wisata`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pesan_plat` FOREIGN KEY (`plat`) REFERENCES `kendaraan` (`plat`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table travel.petugas
CREATE TABLE IF NOT EXISTS `petugas` (
  `id_ptgs` int(6) NOT NULL AUTO_INCREMENT,
  `nama_ptgs` varchar(30) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`id_ptgs`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table travel.wisata
CREATE TABLE IF NOT EXISTS `wisata` (
  `id_wisata` int(6) NOT NULL AUTO_INCREMENT,
  `kabupaten` varchar(15) NOT NULL,
  `biaya` int(7) NOT NULL,
  `nama_tempat` varchar(15) NOT NULL,
  PRIMARY KEY (`id_wisata`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
