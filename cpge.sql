-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 17 mars 2018 à 13:40
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cpge`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `IdCategorie` int(11) NOT NULL AUTO_INCREMENT,
  `NomCategorie` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`IdCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`IdCategorie`, `NomCategorie`) VALUES
(1, 'Analyse situationnelle et problématisation'),
(2, 'Résolution d\'une problématique par l\'investigation et l\'expérimentation'),
(3, 'Communication et réinvestissement');

-- --------------------------------------------------------

--
-- Structure de la table `competence`
--

DROP TABLE IF EXISTS `competence`;
CREATE TABLE IF NOT EXISTS `competence` (
  `IdCompetence` int(11) NOT NULL AUTO_INCREMENT,
  `NomCompetence` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Commentaire` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `ValeurMaxCurseur` int(4) NOT NULL,
  `IdSousCategorie` int(11) NOT NULL,
  PRIMARY KEY (`IdCompetence`),
  KEY `FK_competence_souscat` (`IdSousCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `competence`
--

INSERT INTO `competence` (`IdCompetence`, `NomCompetence`, `Commentaire`, `ValeurMaxCurseur`, `IdSousCategorie`) VALUES
(1, 'Recueillir,exploiter, analyser et traiter des informations', 'Recueillir,exploiter, analyser et traiter des informations', 4, 1),
(2, 'Observer et explorer', 'Observer et explorer', 4, 1),
(3, 'Analyser et hiérarchiser', 'Analyser et hiérarchiser', 4, 1),
(4, 'Organiser et proposer une démarche diagnostic', 'Organiser et proposer une démarche diagnostic', 4, 1),
(5, 'Présenter la démarche', 'Présenter la démarche', 4, 1),
(6, 'Identifier le problème sous ses différents aspects, dans son environnement technique, culturel', 'Identifier le problème sous ses différents aspects, dans son environnement technique, culturel', 4, 2),
(7, 'Développer une pensée autonome', 'Développer une pensée autonome', 4, 2),
(8, 'Mobiliser les connaissances scientifiques pertinenetes pour résoudre le problème', 'Mobiliser les connaissances scientifiques pertinenetes pour résoudre le problème; du champ disciplinaire ou d\'autres disciplines', 4, 3),
(9, 'Identifier les différentes approches et concepts dans le traitement d\'une question', 'Identifier les différentes approches et concepts dans le traitement d\'une question', 4, 3),
(10, 'Structurer un raisonnement et maitriser des relations de causalités', 'Structurer un raisonnement et maitriser des relations de causalités', 4, 3),
(11, 'Construire une démonstration en suivant une progression logique', 'Construire une démonstration en suivant une progression logique', 4, 3),
(12, 'Maîtriser la méthode exploratoire, le raisonnement itératif', 'Maîtriser la méthode exploratoire, le raisonnement itératif', 4, 3),
(13, 'Déterminer les paramètres scientifiques pertinents pour décrire une situation expérimentale', 'Déterminer les paramètres scientifiques pertinents pour décrire une situation expérimentale', 4, 4),
(14, 'Evaluer l\'ordre de grandeurs des phénomènes et leurs variations', 'Evaluer l\'ordre de grandeurs des phénomènes et leurs variations', 4, 4),
(15, 'Réaliser une manipulation', 'Réaliser une manipulation', 4, 4),
(16, 'Mettre en oeuvre des règles de sécurité et de déontologie', 'Mettre en oeuvre des règles de sécurité et de déontologie', 4, 4),
(17, 'Effecter des représentations graphiques et présenter des résultats', 'Effecter des représentations graphiques et présenter des résultats', 4, 4),
(18, 'Analyser les résultats de façon critique (sources d\'erreur, Incertitudes, précisions ...)', 'Analyser les résultats de façon critique (sources d\'erreur, Incertitudes, précisions ...)', 4, 4),
(19, 'Proposer des améliorations de l\'approche expérimentale', 'Proposer des améliorations de l\'approche expérimentale', 4, 4),
(20, 'Explorer, faire preuve de curiosité et d\'ouverture d\'esprit', 'Explorer, faire preuve de curiosité et d\'ouverture d\'esprit', 4, 5),
(21, 'Apporter un regard critique', 'Apporter un regard critique', 4, 5),
(22, 'Développer une pensée autonome', 'Développer une pensée autonome', 4, 5),
(23, 'Connaissances scientifiques', 'Maîtriser les connaissances scientifiques relevant du champ disciplinaire et d\'autres disciplines, ainsi que les concepts associés', 4, 6),
(24, 'Identifier une question dans un contexte posé', 'Identifier une question dans un contexte posé', 4, 6),
(25, 'Intégrer les différents éléments', 'Intégrer les différents éléments, les hiérarchiser, les aritucler, les mettre en perspective,apporter un regard critique', 4, 6),
(26, 'Structurer un raisonnement', 'Structurer un raisonnement et maîtriser des relations de causalité', 4, 6),
(27, 'Construire une démonstration', 'Construire une démonstration en suivant un raisonnement logique', 4, 6),
(28, 'Construire une argumentation écrite comme orale', 'Construire une argumentation écrite comme orale', 4, 6),
(29, 'Maîtriser les techniques de communication', 'Maîtriser les techniques de communication(synthèse, structure, clarté de l\'expression, maîtrise du langage,en particulier scientifique)', 4, 6),
(30, 'S\'exprimer correctement à l\'écrit', 'S\'exprimer correctement à l\'écrit', 4, 7),
(31, 'Appuyer son propos sur des représentations graphiques appropriées', 'Appuyer son propos sur des représentations graphiques appropriées', 4, 7),
(32, 'S\'exprimer correctement à l\'oral', 'S\'exprimer correctement à l\'oral', 4, 8),
(33, 'Appuyer son propos sur des supports graphiques appropriés', 'Appuyer son propos sur des supports graphiques appropriés', 4, 8),
(34, 'Convaincre', 'Convaincre', 4, 8),
(35, 'S\'adapter au contecte de la communication, savoir dialoguer', 'S\'adapter au contexte de la communication, savoir dialoguer', 4, 8);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `IdEtudiant` int(11) NOT NULL AUTO_INCREMENT,
  `NomEtudiant` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `PrenomEtudiant` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `LoginEtudiant` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `MdpEtudiant` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`IdEtudiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `evaluateur`
--

DROP TABLE IF EXISTS `evaluateur`;
CREATE TABLE IF NOT EXISTS `evaluateur` (
  `IdEvaluateur` int(11) NOT NULL AUTO_INCREMENT,
  `NomEvaluateur` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `PrenomEvaluateur` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `EstAdmin` int(4) NOT NULL,
  `LoginEvaluateur` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `MdpEvaluateur` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`IdEvaluateur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `evaluateur`
--

INSERT INTO `evaluateur` (`IdEvaluateur`, `NomEvaluateur`, `PrenomEvaluateur`, `EstAdmin`, `LoginEvaluateur`, `MdpEvaluateur`) VALUES
(1, 'Sayer', 'Tom', 0, 'TomTom', '1234');

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `IdEvaluation` int(11) NOT NULL AUTO_INCREMENT,
  `nomSujet` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `dateEvaluation` date NOT NULL,
  `curseurCompSc` tinyint(4) NOT NULL,
  `pointsCompSc` tinyint(4) NOT NULL,
  `comCompSc` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curseurComOrale` tinyint(4) NOT NULL,
  `pointsComOrale` tinyint(4) NOT NULL,
  `comComOrale` tinyint(4) DEFAULT NULL,
  `comGlobal` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pointsTotal` tinyint(4) NOT NULL,
  `curseurOrgaIdee` tinyint(4) NOT NULL,
  `pointsOrgaIdee` tinyint(4) NOT NULL,
  `comOrgaIdee` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curseurComEcrite` tinyint(4) NOT NULL,
  `pointsComEcrite` tinyint(4) NOT NULL,
  `comComEcrite` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curseurAnaDoc` tinyint(4) NOT NULL,
  `pointsAnaDoc` tinyint(4) NOT NULL,
  `comAnaDoc` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curseurEntretien` tinyint(4) NOT NULL,
  `pointsEntretien` tinyint(4) NOT NULL,
  `comEntretien` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IdEvaluateur` int(11) NOT NULL,
  `IdEtudiant` int(11) NOT NULL,
  PRIMARY KEY (`IdEvaluation`),
  KEY `FK_evaluation_evaluateur` (`IdEvaluateur`),
  KEY `FK_evaluation_etudiant` (`IdEtudiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `evalue`
--

DROP TABLE IF EXISTS `evalue`;
CREATE TABLE IF NOT EXISTS `evalue` (
  `IdEvaluation` int(11) NOT NULL,
  `IdCompetence` int(11) NOT NULL,
  `curseur` int(4) NOT NULL,
  PRIMARY KEY (`IdEvaluation`,`IdCompetence`),
  KEY `FK_competence_evalue` (`IdCompetence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `souscategorie`
--

DROP TABLE IF EXISTS `souscategorie`;
CREATE TABLE IF NOT EXISTS `souscategorie` (
  `IdSousCategorie` int(11) NOT NULL AUTO_INCREMENT,
  `NomSousCategorie` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `IdCategorie` int(11) NOT NULL,
  PRIMARY KEY (`IdSousCategorie`),
  KEY `FK_souscat_categorie` (`IdCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `souscategorie`
--

INSERT INTO `souscategorie` (`IdSousCategorie`, `NomSousCategorie`, `IdCategorie`) VALUES
(1, 'Conduire une analyse de situation par une démarche de type \"diagnostique\"', 1),
(2, 'Poser une problématique', 1),
(3, 'Conduire une démarche réflexive d\'investigation', 2),
(4, 'Conduire ou analyser une expérimenttation', 2),
(5, 'Annoncer et décrire des perspectives nouvelles', 2),
(6, 'Construire une argumentation scientifique en articulant différentes ressources', 3),
(7, 'Organiser une production écrite', 3),
(8, 'Structuer et présenter une communication orale', 3);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `competence`
--
ALTER TABLE `competence`
  ADD CONSTRAINT `FK_competence_souscat` FOREIGN KEY (`IdSousCategorie`) REFERENCES `souscategorie` (`IdSousCategorie`),
  ADD CONSTRAINT `FKne84rwphp68clr6hkojbcgsvw` FOREIGN KEY (`IdSousCategorie`) REFERENCES `souscategorie` (`IdSousCategorie`);

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `FK414vlg340miv24n20sd50bgc0` FOREIGN KEY (`IdEtudiant`) REFERENCES `etudiant` (`IdEtudiant`),
  ADD CONSTRAINT `FK_evaluation_etudiant` FOREIGN KEY (`IdEtudiant`) REFERENCES `etudiant` (`IdEtudiant`),
  ADD CONSTRAINT `FK_evaluation_evaluateur` FOREIGN KEY (`IdEvaluateur`) REFERENCES `evaluateur` (`IdEvaluateur`),
  ADD CONSTRAINT `FKrerljq0qos1nshekxv5tc3bpa` FOREIGN KEY (`IdEvaluateur`) REFERENCES `evaluateur` (`IdEvaluateur`);

--
-- Contraintes pour la table `evalue`
--
ALTER TABLE `evalue`
  ADD CONSTRAINT `FK6thv87urxm2310luupd9hadqk` FOREIGN KEY (`IdEvaluation`) REFERENCES `evaluation` (`IdEvaluation`),
  ADD CONSTRAINT `FK_competence_evalue` FOREIGN KEY (`IdCompetence`) REFERENCES `competence` (`IdCompetence`),
  ADD CONSTRAINT `FK_evaluation_evalue` FOREIGN KEY (`IdEvaluation`) REFERENCES `evaluation` (`IdEvaluation`),
  ADD CONSTRAINT `FKq0xvu2l4lju421jcn4dclu21x` FOREIGN KEY (`IdCompetence`) REFERENCES `competence` (`IdCompetence`);

--
-- Contraintes pour la table `souscategorie`
--
ALTER TABLE `souscategorie`
  ADD CONSTRAINT `FK_souscat_categorie` FOREIGN KEY (`IdCategorie`) REFERENCES `categorie` (`IdCategorie`),
  ADD CONSTRAINT `FKfcvwjqd81a33xsmrpk02bx17f` FOREIGN KEY (`IdCategorie`) REFERENCES `categorie` (`IdCategorie`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
