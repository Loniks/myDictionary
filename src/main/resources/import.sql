USE `mydictionary`;

CREATE TABLE IF NOT EXISTS `words` (
  `word` varchar(45) NOT NULL,
  `meaning` varchar(140) NOT NULL,
  `rating` int(11) DEFAULT '0',
  PRIMARY KEY (`word`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT IGNORE INTO `words` VALUES ('apple','a round fruit with firm, white flesh and a green, red, or yellow skin',1);
INSERT IGNORE INTO `words` VALUES ('banana','a long, curved fruit with a yellow skin and soft, sweet, white flesh inside',13);
INSERT IGNORE INTO `words` VALUES ('cat','an animal what say meow',0);
INSERT IGNORE INTO `words` VALUES ('dog','Animal what say woof',0);
INSERT IGNORE INTO `words` VALUES ('elephant','a very large plant-eating mammal with a prehensile trunk, long curved ivory tusks, and large ears, native to Africa and southern Asia.',-1);
INSERT IGNORE INTO `words` VALUES ('Mom','Women, who born me',16);
INSERT IGNORE INTO `words` VALUES ('orange','a round sweet fruit that has a thick orange skin and an orange centre divided into many parts',-1);