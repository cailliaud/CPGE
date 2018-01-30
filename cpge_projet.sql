-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 26 Décembre 2017 à 17:48
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cpge_projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `IdCategorie` int(2) NOT NULL,
  `NomCategorie` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `competence`
--

CREATE TABLE `competence` (
  `IdCompetence` int(2) NOT NULL,
  `NomCompetence` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Commentaire` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ValeurMaxCurseur` int(2) NOT NULL,
  `IdSousCategorie` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `IdEtudiant` int(3) NOT NULL,
  `NomEtudiant` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `PrenomEtudiant` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `LoginEtudiant` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `MdpEtudiant` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `evaluateur`
--

CREATE TABLE `evaluateur` (
  `IdEvaluateur` int(2) NOT NULL,
  `NomEvaluateur` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `PrenomEvaluateur` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `EstAdmin` tinyint(4) NOT NULL,
  `LoginEvaluateur` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `MdpEvaluateur` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `IdMatiere` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

CREATE TABLE `evaluation` (
  `IdEvaluation` int(4) NOT NULL,
  `Sujet` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Type` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Date` date NOT NULL,
  `Note` int(2) NOT NULL,
  `CommG` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `IdEtudiant` int(3) NOT NULL,
  `IdMatiere` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `evalue`
--

CREATE TABLE `evalue` (
  `IdEvaluation` int(4) NOT NULL,
  `IdCompetence` int(2) NOT NULL,
  `Curseur` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE `matiere` (
  `IdMatiere` int(2) NOT NULL,
  `NomMatiere` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `souscategorie`
--

CREATE TABLE `souscategorie` (
  `IdSousCategorie` int(2) NOT NULL,
  `NomSousCategorie` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `IdCategorie` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`IdCategorie`);

--
-- Index pour la table `competence`
--
ALTER TABLE `competence`
  ADD PRIMARY KEY (`IdCompetence`),
  ADD KEY `Competence_IdSousCategorie_FK` (`IdSousCategorie`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`IdEtudiant`);

--
-- Index pour la table `evaluateur`
--
ALTER TABLE `evaluateur`
  ADD PRIMARY KEY (`IdEvaluateur`),
  ADD KEY `Evaluateur_IdMatiere_FK` (`IdMatiere`);

--
-- Index pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD PRIMARY KEY (`IdEvaluation`),
  ADD KEY `Evaluation_IdEtudiant_FK` (`IdEtudiant`),
  ADD KEY `Evaluation_IdMatiere_FK` (`IdMatiere`);

--
-- Index pour la table `evalue`
--
ALTER TABLE `evalue`
  ADD PRIMARY KEY (`IdEvaluation`,`IdCompetence`),
  ADD KEY `Evalue_IdCompetence_FK` (`IdCompetence`);

--
-- Index pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`IdMatiere`);

--
-- Index pour la table `souscategorie`
--
ALTER TABLE `souscategorie`
  ADD PRIMARY KEY (`IdSousCategorie`),
  ADD KEY `SousCategorie_IdCategorie_FK` (`IdCategorie`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `IdCategorie` int(2) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `competence`
--
ALTER TABLE `competence`
  MODIFY `IdCompetence` int(2) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `IdEtudiant` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `evaluateur`
--
ALTER TABLE `evaluateur`
  MODIFY `IdEvaluateur` int(2) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `evaluation`
--
ALTER TABLE `evaluation`
  MODIFY `IdEvaluation` int(4) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `souscategorie`
--
ALTER TABLE `souscategorie`
  MODIFY `IdSousCategorie` int(2) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `competence`
--
ALTER TABLE `competence`
  ADD CONSTRAINT `Competence_IdSousCategorie_FK` FOREIGN KEY (`IdSousCategorie`) REFERENCES `souscategorie` (`IdSousCategorie`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `evaluateur`
--
ALTER TABLE `evaluateur`
  ADD CONSTRAINT `Evaluateur_IdMatiere_FK` FOREIGN KEY (`IdMatiere`) REFERENCES `matiere` (`IdMatiere`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `Evaluation_IdEtudiant_FK` FOREIGN KEY (`IdEtudiant`) REFERENCES `etudiant` (`IdEtudiant`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Evaluation_IdMatiere_FK` FOREIGN KEY (`IdMatiere`) REFERENCES `matiere` (`IdMatiere`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `evalue`
--
ALTER TABLE `evalue`
  ADD CONSTRAINT `Evalue_IdCompetence_FK` FOREIGN KEY (`IdCompetence`) REFERENCES `competence` (`IdCompetence`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Evalue_IdEvaluation_FK` FOREIGN KEY (`IdEvaluation`) REFERENCES `evaluation` (`IdEvaluation`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `souscategorie`
--
ALTER TABLE `souscategorie`
  ADD CONSTRAINT `SousCategorie_IdCategorie_FK` FOREIGN KEY (`IdCategorie`) REFERENCES `categorie` (`IdCategorie`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
