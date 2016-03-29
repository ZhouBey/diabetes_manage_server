/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50547
Source Host           : 139.129.34.235:3306
Source Database       : diabetes_manage

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-03-19 22:43:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answers
-- ----------------------------
DROP TABLE IF EXISTS `answers`;
CREATE TABLE `answers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(500) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `create_d` timestamp NULL DEFAULT NULL,
  `update_d` timestamp NULL DEFAULT NULL,
  `delete_d` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answers
-- ----------------------------
INSERT INTO `answers` VALUES ('5', '傻屌', '4', '2016-03-05 23:04:14', null, null);
INSERT INTO `answers` VALUES ('6', '聚聚', '4', '2016-03-05 23:04:31', null, null);

-- ----------------------------
-- Table structure for app_token
-- ----------------------------
DROP TABLE IF EXISTS `app_token`;
CREATE TABLE `app_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(50) DEFAULT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `duration` int(11) DEFAULT NULL,
  `role_type` int(11) DEFAULT NULL,
  `create_d` timestamp NULL DEFAULT NULL,
  `update_d` timestamp NULL DEFAULT NULL,
  `delete_d` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_token
-- ----------------------------
INSERT INTO `app_token` VALUES ('12', 'ab12a80e56dd7117ed778a69612a0e18', '9', '86400', '0', '2016-03-03 22:32:03', '2016-03-19 20:22:03', null);
INSERT INTO `app_token` VALUES ('13', '5eaf3241d165bd3e2d50977e66aee77a', '4', '86400', '1', '2016-03-04 16:42:42', '2016-03-16 13:40:40', null);
INSERT INTO `app_token` VALUES ('14', '21108350b8302c1304234765ed524632', '10', '86400', '0', '2016-03-09 14:06:01', '2016-03-09 14:18:31', null);

-- ----------------------------
-- Table structure for blood_sugar_log
-- ----------------------------
DROP TABLE IF EXISTS `blood_sugar_log`;
CREATE TABLE `blood_sugar_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sufferer_id` int(11) DEFAULT NULL,
  `sugar_content` double(11,2) DEFAULT NULL,
  `create_d` timestamp NULL DEFAULT NULL,
  `update_d` timestamp NULL DEFAULT NULL,
  `delete_d` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blood_sugar_log
-- ----------------------------
INSERT INTO `blood_sugar_log` VALUES ('16', '9', '11.00', '2016-03-06 11:15:34', null, null);
INSERT INTO `blood_sugar_log` VALUES ('17', '9', '3.00', '2016-03-08 14:14:32', null, null);
INSERT INTO `blood_sugar_log` VALUES ('18', '9', '6.00', '2016-03-09 14:21:32', null, null);
INSERT INTO `blood_sugar_log` VALUES ('19', '9', '2.00', '2016-03-10 09:52:31', null, null);

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `hospital` varchar(30) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `certificate_image` varchar(50) DEFAULT NULL,
  `is_activate` int(2) DEFAULT '0',
  `create_d` timestamp NULL DEFAULT NULL,
  `update_d` timestamp NULL DEFAULT NULL,
  `delete_d` timestamp NULL DEFAULT NULL,
  `post` varchar(20) DEFAULT NULL,
  `info` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('4', '周培源', '13837113789', '5d93ceb70e2bf5daa84ec3d0cd2c731a', '0', '1993-03-15 00:00:00', null, '河南中医学院第一附属医院', null, 'photoImage/1457080962481', '0', '2016-03-04 16:42:42', null, null, '院长', '我是专业的哦');

-- ----------------------------
-- Table structure for doctor_patient
-- ----------------------------
DROP TABLE IF EXISTS `doctor_patient`;
CREATE TABLE `doctor_patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sufferer_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `create_d` timestamp NULL DEFAULT NULL,
  `update_d` timestamp NULL DEFAULT NULL,
  `delete_d` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor_patient
-- ----------------------------
INSERT INTO `doctor_patient` VALUES ('8', '9', '4', '2016-03-06 15:00:04', null, null);

-- ----------------------------
-- Table structure for health_info
-- ----------------------------
DROP TABLE IF EXISTS `health_info`;
CREATE TABLE `health_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `info_image` varchar(100) DEFAULT NULL,
  `msg` varchar(5000) DEFAULT NULL,
  `create_d` timestamp NULL DEFAULT NULL,
  `update_d` timestamp NULL DEFAULT NULL,
  `delete_d` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of health_info
-- ----------------------------
INSERT INTO `health_info` VALUES ('1', '关注儿童糖尿病并发症刻不容缓', '/201512070949047287.jpg', '<p>我国糖尿病的发病率在世界上虽然不是最高的，但由于人口众多，患病的绝对人数仅次于美国，居世界第二位，而且随着我国经济的迅速发展，糖尿病的发病率在我国，特别是在我国的大中城市明显上升。其中1型糖尿病大部分发生在儿童及青少年时期，儿童1型糖尿病通常起病急，病程长，早期就易出现各种并发症，严重危害着儿童及青少年的身心健康和生活质量。 </p><p>　　 </p><p>　　<strong>案例解读： <br></strong>　　1.小明今年6岁了，9月份该上小学的他却怎么也高兴不起来。原来，一个月前，他因为酮症酸中毒而被送往了医院，经医生诊断，证明小明患上了1型糖尿病，这个消息如同晴天霹雳，给本来快乐的家庭蒙上了一层阴影。小明的妈妈难过的说，那天孩子突然觉得恶心，而且还呕吐，我们很着急连忙送往了最近的医院，谁知竟是得了糖尿病！ </p><p>　　2.小群是个名副其实的小胖墩，12岁的他身高1米6，体重居然有80多公斤。两个月前，小群妈妈带他去医院做体检，因为小群的妈妈患有妊娠糖尿病，所以医生也建议给小群查个血糖，结果小群的空腹血糖居然达到14.3mmol/L，经进一步检查确诊为2型糖尿病。 </p><p>　　 </p><p>　　<strong>儿童患糖尿病的征兆 <br></strong>　　 </p><p>　　1型糖尿病目前不太容易找到高危因素，但儿童2型糖尿病的很多高危因素已被发现，常见的高危因素有以下几种：过胖；有糖尿病家族史；有胰岛素抵抗性的病症（如黑色棘皮病，即孩子的颈部、腋窝、大腿根部皮肤有黑的色素沉着、角化过度、疣状增生）；母亲在怀孕时有妊娠性糖尿病；有导致胰岛素抵抗性的疾病，如多囊卵巢综合征。如果孩子出现以上高危因素中的一种或几种，就应定期带孩子去内分泌科，监测血糖、尿糖、血脂、血压等指标，以便早发现、早干预。 </p><p>　　 </p><p>　　<strong>温馨提示：当孩子出现以下征兆时，应及时就医。 <br></strong>　　1.多尿、小便频，有些大孩子，表现为已很多年不尿床，现在尿床又反复出现； </p><p>　　2.经常口渴，有时夜间也要起来喝水； </p><p>　　3.食量大增，饥饿感增强，以前不吃的东西也拿来充饥； </p><p>　　4.容易疲倦，喜欢在家里拒绝外出，喜欢选择室内娱乐活动，喜欢蹲着、坐着，并经常喜欢躺着看电视； </p><p>　　5.体重骤降，有些孩子一直在控制饮食，但效果并不理想，突然出现体重下降； </p><p>　　6.视力模糊； </p><p>　　7.皮肤和阴部瘙痒或反复的泌尿系统感染，往往表现为腹痛和呕吐，因进食不足和反复呕吐使血糖水平暂时下降，或因肾糖阈异常，而出现尿糖阴性的表现，容易导致漏诊； </p><p>　　8.伤口较难愈合，特别是伤口反复感染、渗出、久不愈合； </p><p>　　9.酮症酸中毒的症状：腹痛、恶心、呕吐，呼吸快而深、昏睡、神志不清，甚至昏迷。 </p><p>　　 </p><p>　　<strong>儿童并发症都有哪些？ <br></strong>　　 </p><p>　　糖尿病的并发症往往会对患儿生命造成不可逆的伤害，因此值得医生、家长及教育者给予更多的重视。1型糖尿病患儿对胰岛素一般都教敏感，在治疗过程中，剂量掌握不好容易发生低血糖反应。反应多出现于胰岛素作用强时，正规胰岛素多在注射后3~4小时发生低血糖反应，中效或长效者在夜间或次晨早饭前出现，表现为苍白、软弱、倦怠、头晕、饥饿或出汗、心悸，甚至抽搐、昏迷等。因此，在治疗过程中，家长要密切观察患儿的各种反应，一旦出现低血糖反应，应及时给予救治。糖尿病久病后常伴心脑血管、肾、眼及神经等病变，严重时导致酸碱平衡失调而危机生命。如能及早防治，严格和持久地控制高血糖，加强护理，可提高患儿的生活质量，同时减少并发症的发生。 </p><p>　　 </p><p>　<strong>　急性并发症之胰岛素反应——低血糖症 <br></strong>　　 </p><p>　　糖尿病的特征是血糖过高，胰岛素能降低血糖，但是使用不当亦能导致血糖过低，找出所谓“胰岛素反应”或“低血糖症”。 </p><p>　　低血糖症是指当血糖值下降至低于某一水平时出现的一系列的症状。症状的多少及出现低血糖症状的血糖水平，是因人而异的。大部分的儿童，在血糖低至3.0~4.0mmol/L时，便会出现症状。 </p><p>　　低血糖症的原因：注射过量胰岛素；注射胰岛素后，没有及时进食，或没有进食含足够碳水化合物的食物；注射胰岛素后，进行比平常消耗量大的运动。平常血糖控制得很好的病人，尤其容易因为发生后两种原因而出现低血糖症。 </p><p>　　低血糖的表现 </p><p>　　低血糖表现为心跳加速、手颤、出汗、面色苍白、麻痹感、颤抖、焦虑、虚弱、恶心、呕吐、头晕等。在婴儿期，这些症状可能不明显，可表现为呼吸暂停、拒绝进食、软弱小发作、肌痉挛抽搐、嗜睡、低体温和痉挛等非特异的表现。 </p><p>　　<strong>导致低血糖症状的原因 <br></strong>　　1.为了维持一定的血糖值，当血糖下降至危险水平时，身体会分泌一些与胰岛素相抗衡的激素，其中主要有肾上腺素，它能导致心跳加速、手颤、出汗等症状。 </p><p>　　2.由于血糖是脑细胞的主要燃料之一，血糖不足，脑细胞不能正常运作，便会出现头晕、抽搐、神志失常等症状。脑细胞长时间缺乏葡萄糖作为燃料，会受到一定的损害。6岁以下的孩童，由于脑部正处于迅速的发育期，脑细胞特别容易受损，所以应尽量避免低血糖，最好是在任何时候都能把血糖保持在4mmol/L以上。 </p><p>　　低血糖症一般可以划分为轻微、中度、严重三个级别，分别表现为一些症状。 </p><p>　　另外，由于有些病人低血糖的症状不一定明显，如果在测试血糖时，发现血糖值低于3mmol/L，亦应作为低血糖症处理。 </p><p>　　 </p><p>　　<strong>轻或中度低血糖症的处理 <br></strong>　　 </p><p>　　1.立刻给病人服食高糖食物，最好是含有一定浓度糖的水或其他流质。 </p><p>　　2.若五分钟内症状仍未有改善，可以再给病人一份高糖食物。 </p><p>　　3.血糖回升后，应提早进餐（轻微低血糖症）或先吃一份含碳水化合物的加餐（中度低血糖症），如面包、饼干、牛奶等，以避免血糖再次下降。 </p><p>　　4.详细记录低血糖症的发生时间、血糖值及导致低血糖的原因，以便日后复诊时和医生商讨对策。 </p><p>　　5.分析导致低血糖的原因。若非由于减少/忘记进食或运动量过大，则应于次日起将相应的胰岛素剂量减少十分之一。 </p><p>　　6.若血糖值低于3mmol/L，即使没有低血糖症状，亦应立刻服食一份高糖食物，并于次日起将相应的胰岛素机理减少十分之一。 </p><p>　　低血糖症的反弹现象 </p><p>　　反弹现象的出现，是因为身体为了维持一定的血糖水平，在血糖过低时，大量分泌了一些与胰岛素相抗衡的激素。这些激素不仅能使血糖上升（“反弹”），还会影响脂肪的新陈代谢，产生酮体。 </p><p>　　认识“反弹”现象的重要性，在于出现高血糖值的时候能考虑到“反弹”的可能性。比如有些病人，半夜里会有轻微的低血糖症，却由于当时睡着了而没有察觉，唯一的线索可能就是翌日造成的高血糖值。因此，若出现以下情况，就应该测试一下清晨2～3时的血糖值。</p>', '2015-12-11 21:20:04', null, null);
INSERT INTO `health_info` VALUES ('2', '中年女性谨防糖尿病', '/222.jpg', '<p>患上糖尿病很多病人的各方面的压力是很大的，糖尿病患者一定要注意选择合适自己的护理，积极的来发现糖尿病的出现，及时的做好糖尿病是护理的工作，人们要注意其中的原因，那么，中年女性为什么易患糖尿病呢？</p><p> </p><p>　　<strong>1、肥胖。</strong>通常情况下，人到中年都会出现发福的情况，大多数中年人的体重都比较容易出现上升的现象。在中年时期，肥胖与糖尿病这对孪生子常常相伴悄然来到中年女性的身边。女性肥胖的危害很大，能够造成高血压、胰岛素抵抗、冠心病、血脂异常症、胆石症、肺功能不全、痛风等等，特别是糖尿病及其并发症，可能引起残废或者早亡。因此，中年女性为了不得或少得糖尿病，要避免中年发胖。</p><p> </p><p>　　<strong>2、更年期。</strong>每个女人到了一定的年龄就会进入更年期，这是不可避免的，对此，应加以重视。中国女性的更年期出现于43岁～59岁。更年期内分泌系统的变化是多方面的，包括卵巢雌激素分泌减少，为绝经前的20%;雄激素分泌减少，为绝经期前的50%左右;外周组织将雄烯二酮转化为睾酮等雄激素的能力升高，结果导致雌激素/雄激素比值降低，这种降低会导致女性胰岛素抵抗的加重，胰岛负担加重，再加上年龄增加(增龄)以及更年期容易出现的肥胖，导致更年期成为糖尿病的好发阶段。</p>', '2015-12-11 21:24:38', null, null);
INSERT INTO `health_info` VALUES ('3', '六个细节易引起糖尿病', '/333.jpg', '<p>引发糖尿病的因素并不全都是“吃得太多，动得太少”，日常生活中的一些隐性角落里随时会向人们发送“致糖炸弹”。</p><p>　　<strong>1.香味蜡烛。</strong>化学合成的香味蜡烛中含有的邻苯二甲酸盐是一种能够扰乱激素分泌的化学物质，它的绰号是“致胖激素”，因为它有可能导致人们体重增加。瑞典乌普萨拉大学的一项研究显示：体内邻苯二甲酸盐浓度较高的人患上糖尿病的可能性会翻倍。</p><p> </p><p>　<strong>　对策：</strong>尽量选用蜂蜡做成的蜡烛。不要使用乙烯基塑料材质的浴帘，因为乙烯基中也含有邻苯二甲酸盐。棉制和麻制的浴帘是最佳选择，麻制品还具有天然的抗菌特性。</p><p> </p><p>　<strong>　2.各种芳香剂。</strong>空气清新剂、香水、花露水和普通的清洁用品都含有让代谢紊乱的化学物质，扰乱激素分泌水平，从而增加人们患糖尿病的风险。</p><p> </p><p>　<strong>　对策：</strong>避免使用成份列表中含有“香料”或“香精”字样的个人护理用品。选用不带香味的肥皂和天然洗涤用品，如茶粉、小苏打和醋。</p><p> </p><p>　　<strong>3.塑料饮水杯。</strong>英国埃克塞特大学的研究显示：双酚A与脂肪细胞加速生长、胰腺细胞功能遭到扰乱之间存在关联，而后两者会导致胰岛素抵抗。</p><p> </p><p>　<strong>　对策：</strong>双酚A存在于很多底部标有“7”的塑料制品中，所以最好选择玻璃材质或专用于食品类的不锈钢材质的水杯。要特别留心那些声称不含双酚A的塑料制品，它们很有可能是双酚A的替代物，没有通过安全性测试。</p><p> </p><p>　　<strong>4.杀虫剂。</strong>新烟碱类杀虫剂与引发糖尿病的胰腺功能紊乱之间存在关联。另一类杀虫剂(氨基甲酸盐)也与糖尿病的发病存在关联。这两类杀虫剂的残余物通常存在于采用非有机方法种植的草莓和桃子等蔬果中。</p><p> </p><p>　　<strong>对策</strong>：选择有机食品。真正的有机食品意味着农作物在种植过程中没有使用合成农药。</p><p> </p><p>　　<strong>5.二手烟。</strong>美国国家环境卫生科学研究所发表在《环境健康展望期刊》上的一份报告显示，大人吸烟会增加家中孩子日后患上肥胖症的风险。特别是孕妇产前经常暴露在二手烟的环境中，孩子日后患上代谢综合征的可能性更大。</p><p> </p><p>　　<strong>对策：</strong>为了自己和家人的健康，戒烟和避免接触二手烟和三手烟。</p><p> </p><p>　　<strong>6.睡眠差。</strong>即使是一个晚上缺乏睡眠也会导致人体出现胰岛素抵抗的迹象。慢性失眠是糖尿病发病的主要风险因素。近期发表在《科学转化医学》上的研究显示，每晚睡眠时间不到6小时的人出现胰岛素抵抗的可能性会增加4.5倍。</p><p> </p><p>　　<strong>对策：</strong>睡觉前两个小时就要远离电脑和电视屏幕，熄灭所有光源，以提高睡眠质量。</p>', '2015-12-11 21:25:39', null, null);
INSERT INTO `health_info` VALUES ('26', '糖友护肝也需有道', '/111.jpg', '<p>肝脏在糖脂代谢中发挥重要功能，它不仅是葡萄糖仓库，通过血胰岛素水平以及对胰岛素的敏感性控制血糖水平。糖尿病与肝脏健康关系密切，所以无论是糖尿病患者还是糖尿病高危人群，都应关注着肝脏健康。日常治疗护肝需遵循以下原则：</p><p> </p><p>　　1.高血糖等疾病和肝脏疾病易发于肥胖、生活不规律、嗜酒、吸烟等人群，所以上述人群需定期进行体检，监测血压、血脂、血糖、肝功水平。还要注意保持健康的生活习惯，避免熬夜、饮酒、吸烟等不利于肝脏健康的坏毛病。日常生活中如果出现恶心、呕吐、乏力等症状时，还要到医院进行检查，尤其是肝功能检查，这是因为肝脏是重要的解毒代谢器官，如果代谢水平降低，会使有毒物质蓄积于血液或影响营养物质的合成，从而出现不适症状。</p><p>　　2. 要保持乐观健康的心态，这样有助于疾病的康复。一些糖尿病患者体内由于胰岛素分泌不足或相对缺乏容易引发肝脏的糖代谢紊乱，肝脏对糖的利用减少，释放增加，导致了肝损伤。这时如果盲目悲观，只会造成两种疾病同时加重，只有保持乐观的心态，才能远离疾病带来的困扰。</p><p>　　3. 糖尿病及糖尿病高危人群，在服用治疗或预防药物时一定要配合服用保肝护肝药物。常用的保肝护肝中药有五味子、茵陈、柴胡、甘草等，也可以服用成药如葵花护肝片等，此类中成药可修复肝损伤，还能有效协同控制糖尿病病情和病程。</p><p>　　无论是糖友还是高危人群，日常生活中都应提高警惕，防止疾病的发生和发展，同时科学及时的保护肝脏。</p>', '2015-12-11 21:23:14', null, null);

-- ----------------------------
-- Table structure for opinion
-- ----------------------------
DROP TABLE IF EXISTS `opinion`;
CREATE TABLE `opinion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `create_d` timestamp NULL DEFAULT NULL,
  `update_d` timestamp NULL DEFAULT NULL,
  `delete_d` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of opinion
-- ----------------------------

-- ----------------------------
-- Table structure for question_and_answer
-- ----------------------------
DROP TABLE IF EXISTS `question_and_answer`;
CREATE TABLE `question_and_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL,
  `answer_id` int(11) DEFAULT NULL,
  `create_d` timestamp NULL DEFAULT NULL,
  `update_d` timestamp NULL DEFAULT NULL,
  `delete_d` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_and_answer
-- ----------------------------
INSERT INTO `question_and_answer` VALUES ('26', '32', null, '2016-03-05 23:03:44', null, null);
INSERT INTO `question_and_answer` VALUES ('27', '32', '5', '2016-03-05 23:04:14', null, null);
INSERT INTO `question_and_answer` VALUES ('28', '32', '6', '2016-03-05 23:04:31', null, null);
INSERT INTO `question_and_answer` VALUES ('29', '33', null, '2016-03-09 14:19:36', null, null);

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `content` varchar(50) DEFAULT NULL,
  `sufferer_id` int(11) DEFAULT NULL,
  `create_d` timestamp NULL DEFAULT NULL,
  `update_d` timestamp NULL DEFAULT NULL,
  `delete_d` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES ('32', '哈哈哈', '积极啦啦啦啦，嗨你妹', '9', '2016-03-05 23:03:44', null, null);
INSERT INTO `questions` VALUES ('33', '啦啦', '我是开叉南路', '10', '2016-03-09 14:19:36', null, null);

-- ----------------------------
-- Table structure for sufferer
-- ----------------------------
DROP TABLE IF EXISTS `sufferer`;
CREATE TABLE `sufferer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `phone` varchar(11) NOT NULL,
  `sex` int(2) DEFAULT '-1',
  `birthday` timestamp NULL DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `suffered_date` timestamp NULL DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `create_d` timestamp NULL DEFAULT NULL,
  `update_d` timestamp NULL DEFAULT NULL,
  `delete_d` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sufferer
-- ----------------------------
INSERT INTO `sufferer` VALUES ('9', '周培源', '13837113789', '0', '2016-03-17 00:00:00', null, '2016-03-03 00:00:00', 'photoImage/1457079832675', '5d93ceb70e2bf5daa84ec3d0cd2c731a', '2016-03-03 22:32:03', '2016-03-06 11:16:21', null);
INSERT INTO `sufferer` VALUES ('10', '卢星星', '15729383929', '-1', null, null, null, null, '5d93ceb70e2bf5daa84ec3d0cd2c731a', '2016-03-09 14:06:01', '2016-03-09 14:06:17', null);
