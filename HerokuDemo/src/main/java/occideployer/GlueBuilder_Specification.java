/**
 * Copyright (c) 2016-2017 Inria
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * - Lê Khánh Trình <trinh.le-khanh@inria.fr>
 *
 * Generated at Wed Jan 12 21:26:57 CET 2022 from platform:/resource/HerokuDeployer/model/herokudeployer.occie by org.eclipse.cmf.occi.core.gen.connector
 */
package occideployer;

import org.javabip.glue.GlueBuilder;

public class GlueBuilder_Specification extends GlueBuilder
{
	@Override
	public void configure() {
		// connector_1:(HerokuDynoType.sub1) - (Deployer.setFreeDyno)
		//ALL Synchron: root.null
				port(HerokuDynoTypeConnector.class, "sub1").requires(DeployerConnector.class, "setFreeDyno");
				port(DeployerConnector.class, "setFreeDyno").requires(HerokuDynoTypeConnector.class, "sub1");

				port(HerokuDynoTypeConnector.class, "sub1").accepts(DeployerConnector.class, "setFreeDyno");
				port(DeployerConnector.class, "setFreeDyno").accepts(HerokuDynoTypeConnector.class, "sub1");

		// connector_2:(HerokuDynoType.sendDynoResponse) - (Deployer.receiveDynoResponse)
		//ALL Synchron: root.null
				port(HerokuDynoTypeConnector.class, "sendDynoResponse").requires(DeployerConnector.class, "receiveDynoResponse");
				port(DeployerConnector.class, "receiveDynoResponse").requires(HerokuDynoTypeConnector.class, "sendDynoResponse");

				port(HerokuDynoTypeConnector.class, "sendDynoResponse").accepts(DeployerConnector.class, "receiveDynoResponse");
				port(DeployerConnector.class, "receiveDynoResponse").accepts(HerokuDynoTypeConnector.class, "sendDynoResponse");

		// connector_3:(HerokuRegion.toUS) - (Deployer.setUSRegion)
		//ALL Synchron: root.null
				port(HerokuRegionConnector.class, "toUS").requires(DeployerConnector.class, "setUSRegion");
				port(DeployerConnector.class, "setUSRegion").requires(HerokuRegionConnector.class, "toUS");

				port(HerokuRegionConnector.class, "toUS").accepts(DeployerConnector.class, "setUSRegion");
				port(DeployerConnector.class, "setUSRegion").accepts(HerokuRegionConnector.class, "toUS");

		// connector_4:(HerokuRegion.toEU) - (Deployer.setEURegion)
		//ALL Synchron: root.null
				port(HerokuRegionConnector.class, "toEU").requires(DeployerConnector.class, "setEURegion");
				port(DeployerConnector.class, "setEURegion").requires(HerokuRegionConnector.class, "toEU");

				port(HerokuRegionConnector.class, "toEU").accepts(DeployerConnector.class, "setEURegion");
				port(DeployerConnector.class, "setEURegion").accepts(HerokuRegionConnector.class, "toEU");

		// connector_5:HerokuRegion.setAddonsForEU)` - (HerokuRegion.setAddonsForUS)` - (HerokuPostgres.on) - (HerokuClearDBMySQL.on) - (HerokuScoutAPM.on) - (HerokuNewRelicAPM.on)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "on").requires(HerokuRegionConnector.class, "setAddonsForEU");
				port(HerokuPostgresConnector.class, "on").requires(HerokuRegionConnector.class, "setAddonsForUS");
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuRegionConnector.class, "setAddonsForEU");
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuRegionConnector.class, "setAddonsForUS");
				port(HerokuScoutAPMConnector.class, "on").requires(HerokuRegionConnector.class, "setAddonsForEU");
				port(HerokuScoutAPMConnector.class, "on").requires(HerokuRegionConnector.class, "setAddonsForUS");
				port(HerokuNewRelicAPMConnector.class, "on").requires(HerokuRegionConnector.class, "setAddonsForEU");
				port(HerokuNewRelicAPMConnector.class, "on").requires(HerokuRegionConnector.class, "setAddonsForUS");

				port(HerokuRegionConnector.class, "setAddonsForEU").accepts(HerokuRegionConnector.class, "setAddonsForUS", HerokuPostgresConnector.class, "on", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuRegionConnector.class, "setAddonsForUS").accepts(HerokuRegionConnector.class, "setAddonsForEU", HerokuPostgresConnector.class, "on", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").accepts(HerokuRegionConnector.class, "setAddonsForEU", HerokuRegionConnector.class, "setAddonsForUS", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(HerokuRegionConnector.class, "setAddonsForEU", HerokuRegionConnector.class, "setAddonsForUS", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "on").accepts(HerokuRegionConnector.class, "setAddonsForEU", HerokuRegionConnector.class, "setAddonsForUS", HerokuPostgresConnector.class, "on", HerokuClearDBMySQLConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(HerokuRegionConnector.class, "setAddonsForEU", HerokuRegionConnector.class, "setAddonsForUS", HerokuPostgresConnector.class, "on", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "on");

		// connector_6:[(HerokuClearDBMySQL.on) - (HerokuPostgres.on) - (HerokuScoutAPM.on) - (HerokuNewRelicAPM.on) - (Deployer.setAddonsForUS)]` - (HerokuRegion.setAddonsForUS)
		//Synchron & Trigger
				port(HerokuRegionConnector.class, "setAddonsForUS").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForUS");
		//ALL Synchron: c00.null
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForUS");
				port(HerokuPostgresConnector.class, "on").requires(HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForUS");
				port(HerokuScoutAPMConnector.class, "on").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForUS");
				port(HerokuNewRelicAPMConnector.class, "on").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", DeployerConnector.class, "setAddonsForUS");
				port(DeployerConnector.class, "setAddonsForUS").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");

				port(HerokuClearDBMySQLConnector.class, "on").accepts(HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForUS", HerokuRegionConnector.class, "setAddonsForUS");
				port(HerokuPostgresConnector.class, "on").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForUS", HerokuRegionConnector.class, "setAddonsForUS");
				port(HerokuScoutAPMConnector.class, "on").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForUS", HerokuRegionConnector.class, "setAddonsForUS");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", DeployerConnector.class, "setAddonsForUS", HerokuRegionConnector.class, "setAddonsForUS");
				port(DeployerConnector.class, "setAddonsForUS").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", HerokuRegionConnector.class, "setAddonsForUS");
				port(HerokuRegionConnector.class, "setAddonsForUS").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForUS");

		// connector_7:[(HerokuClearDBMySQL.on) - (HerokuPostgres.on) - (HerokuScoutAPM.on) - (HerokuNewRelicAPM.on) - (Deployer.setAddonsForEU)]` - (HerokuRegion.setAddonsForEU)
		//Synchron & Trigger
				port(HerokuRegionConnector.class, "setAddonsForEU").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForEU");
		//ALL Synchron: c00.null
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForEU");
				port(HerokuPostgresConnector.class, "on").requires(HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForEU");
				port(HerokuScoutAPMConnector.class, "on").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForEU");
				port(HerokuNewRelicAPMConnector.class, "on").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", DeployerConnector.class, "setAddonsForEU");
				port(DeployerConnector.class, "setAddonsForEU").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");

				port(HerokuClearDBMySQLConnector.class, "on").accepts(HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForEU", HerokuRegionConnector.class, "setAddonsForEU");
				port(HerokuPostgresConnector.class, "on").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForEU", HerokuRegionConnector.class, "setAddonsForEU");
				port(HerokuScoutAPMConnector.class, "on").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForEU", HerokuRegionConnector.class, "setAddonsForEU");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", DeployerConnector.class, "setAddonsForEU", HerokuRegionConnector.class, "setAddonsForEU");
				port(DeployerConnector.class, "setAddonsForEU").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", HerokuRegionConnector.class, "setAddonsForEU");
				port(HerokuRegionConnector.class, "setAddonsForEU").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", DeployerConnector.class, "setAddonsForEU");

		// connector_8:(HerokuRegion.setAddonsForUS)` - (Deployer.setAddonsForUS)
		//Synchron & Trigger
				port(DeployerConnector.class, "setAddonsForUS").requires(HerokuRegionConnector.class, "setAddonsForUS");

				port(HerokuRegionConnector.class, "setAddonsForUS").accepts(DeployerConnector.class, "setAddonsForUS");
				port(DeployerConnector.class, "setAddonsForUS").accepts(HerokuRegionConnector.class, "setAddonsForUS");

		// connector_9:(HerokuRegion.setAddonsForEU)` - (Deployer.setAddonsForEU)
		//Synchron & Trigger
				port(DeployerConnector.class, "setAddonsForEU").requires(HerokuRegionConnector.class, "setAddonsForEU");

				port(HerokuRegionConnector.class, "setAddonsForEU").accepts(DeployerConnector.class, "setAddonsForEU");
				port(DeployerConnector.class, "setAddonsForEU").accepts(HerokuRegionConnector.class, "setAddonsForEU");

		// connector_10:(Deployer.setJava) - (HerokuBuildpack.setJava)
		//ALL Synchron: root.null
				port(DeployerConnector.class, "setJava").requires(HerokuBuildpackConnector.class, "setJava");
				port(HerokuBuildpackConnector.class, "setJava").requires(DeployerConnector.class, "setJava");

				port(DeployerConnector.class, "setJava").accepts(HerokuBuildpackConnector.class, "setJava");
				port(HerokuBuildpackConnector.class, "setJava").accepts(DeployerConnector.class, "setJava");

		// connector_11:(Deployer.setScala) - (HerokuBuildpack.setScala)
		//ALL Synchron: root.null
				port(DeployerConnector.class, "setScala").requires(HerokuBuildpackConnector.class, "setScala");
				port(HerokuBuildpackConnector.class, "setScala").requires(DeployerConnector.class, "setScala");

				port(DeployerConnector.class, "setScala").accepts(HerokuBuildpackConnector.class, "setScala");
				port(HerokuBuildpackConnector.class, "setScala").accepts(DeployerConnector.class, "setScala");

		// connector_12:(Deployer.setPython) - (HerokuBuildpack.setPython)
		//ALL Synchron: root.null
				port(DeployerConnector.class, "setPython").requires(HerokuBuildpackConnector.class, "setPython");
				port(HerokuBuildpackConnector.class, "setPython").requires(DeployerConnector.class, "setPython");

				port(DeployerConnector.class, "setPython").accepts(HerokuBuildpackConnector.class, "setPython");
				port(HerokuBuildpackConnector.class, "setPython").accepts(DeployerConnector.class, "setPython");

		// connector_13:(Deployer.setRuby) - (HerokuBuildpack.setRuby)
		//ALL Synchron: root.null
				port(DeployerConnector.class, "setRuby").requires(HerokuBuildpackConnector.class, "setRuby");
				port(HerokuBuildpackConnector.class, "setRuby").requires(DeployerConnector.class, "setRuby");

				port(DeployerConnector.class, "setRuby").accepts(HerokuBuildpackConnector.class, "setRuby");
				port(HerokuBuildpackConnector.class, "setRuby").accepts(DeployerConnector.class, "setRuby");

		// connector_14:(Deployer.setNodejs) - (HerokuBuildpack.setNodejs)
		//ALL Synchron: root.null
				port(DeployerConnector.class, "setNodejs").requires(HerokuBuildpackConnector.class, "setNodejs");
				port(HerokuBuildpackConnector.class, "setNodejs").requires(DeployerConnector.class, "setNodejs");

				port(DeployerConnector.class, "setNodejs").accepts(HerokuBuildpackConnector.class, "setNodejs");
				port(HerokuBuildpackConnector.class, "setNodejs").accepts(DeployerConnector.class, "setNodejs");

		// connector_15:(Deployer.setClojure) - (HerokuBuildpack.setClojure)
		//ALL Synchron: root.null
				port(DeployerConnector.class, "setClojure").requires(HerokuBuildpackConnector.class, "setClojure");
				port(HerokuBuildpackConnector.class, "setClojure").requires(DeployerConnector.class, "setClojure");

				port(DeployerConnector.class, "setClojure").accepts(HerokuBuildpackConnector.class, "setClojure");
				port(HerokuBuildpackConnector.class, "setClojure").accepts(DeployerConnector.class, "setClojure");

		// connector_16:(Deployer.setGradle) - (HerokuBuildpack.setGradle)
		//ALL Synchron: root.null
				port(DeployerConnector.class, "setGradle").requires(HerokuBuildpackConnector.class, "setGradle");
				port(HerokuBuildpackConnector.class, "setGradle").requires(DeployerConnector.class, "setGradle");

				port(DeployerConnector.class, "setGradle").accepts(HerokuBuildpackConnector.class, "setGradle");
				port(HerokuBuildpackConnector.class, "setGradle").accepts(DeployerConnector.class, "setGradle");

		// connector_17:(Deployer.setJvm) - (HerokuBuildpack.setJvm)
		//ALL Synchron: root.null
				port(DeployerConnector.class, "setJvm").requires(HerokuBuildpackConnector.class, "setJvm");
				port(HerokuBuildpackConnector.class, "setJvm").requires(DeployerConnector.class, "setJvm");

				port(DeployerConnector.class, "setJvm").accepts(HerokuBuildpackConnector.class, "setJvm");
				port(HerokuBuildpackConnector.class, "setJvm").accepts(DeployerConnector.class, "setJvm");

		// connector_18:(Deployer.setPhp) - (HerokuBuildpack.setPhp)
		//ALL Synchron: root.null
				port(DeployerConnector.class, "setPhp").requires(HerokuBuildpackConnector.class, "setPhp");
				port(HerokuBuildpackConnector.class, "setPhp").requires(DeployerConnector.class, "setPhp");

				port(DeployerConnector.class, "setPhp").accepts(HerokuBuildpackConnector.class, "setPhp");
				port(HerokuBuildpackConnector.class, "setPhp").accepts(DeployerConnector.class, "setPhp");

		// connector_19:(Deployer.setGo) - (HerokuBuildpack.setGo)
		//ALL Synchron: root.null
				port(DeployerConnector.class, "setGo").requires(HerokuBuildpackConnector.class, "setGo");
				port(HerokuBuildpackConnector.class, "setGo").requires(DeployerConnector.class, "setGo");

				port(DeployerConnector.class, "setGo").accepts(HerokuBuildpackConnector.class, "setGo");
				port(HerokuBuildpackConnector.class, "setGo").accepts(DeployerConnector.class, "setGo");

		// connector_20:(HerokuBuildpack.setAddonsForJava)` - (HerokuPostgres.on)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForJava");

				port(HerokuBuildpackConnector.class, "setAddonsForJava").accepts(HerokuPostgresConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForJava");

		// connector_21:(HerokuBuildpack.setAddonsForScala)` - (HerokuPostgres.on)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForScala");

				port(HerokuBuildpackConnector.class, "setAddonsForScala").accepts(HerokuPostgresConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForScala");

		// connector_22:(HerokuBuildpack.setAddonsForPython)` - (HerokuPostgres.on)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForPython");

				port(HerokuBuildpackConnector.class, "setAddonsForPython").accepts(HerokuPostgresConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForPython");

		// connector_23:(HerokuBuildpack.setAddonsForRuby)` - (HerokuPostgres.on)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForRuby");

				port(HerokuBuildpackConnector.class, "setAddonsForRuby").accepts(HerokuPostgresConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForRuby");

		// connector_24:(HerokuBuildpack.setAddonsForNodejs)` - (HerokuPostgres.on)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForNodejs");

				port(HerokuBuildpackConnector.class, "setAddonsForNodejs").accepts(HerokuPostgresConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForNodejs");

		// connector_25:(HerokuBuildpack.setAddonsForClojure)` - (HerokuPostgres.on)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForClojure");

				port(HerokuBuildpackConnector.class, "setAddonsForClojure").accepts(HerokuPostgresConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForClojure");

		// connector_26:(HerokuBuildpack.setAddonsForGradle)` - (HerokuPostgres.off)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForGradle");

				port(HerokuBuildpackConnector.class, "setAddonsForGradle").accepts(HerokuPostgresConnector.class, "off");
				port(HerokuPostgresConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForGradle");

		// connector_27:(HerokuBuildpack.setAddonsForJvm)` - (HerokuPostgres.on)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForJvm");

				port(HerokuBuildpackConnector.class, "setAddonsForJvm").accepts(HerokuPostgresConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForJvm");

		// connector_28:(HerokuBuildpack.setAddonsForPhp)` - (HerokuPostgres.on)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForPhp");

				port(HerokuBuildpackConnector.class, "setAddonsForPhp").accepts(HerokuPostgresConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForPhp");

		// connector_29:(HerokuBuildpack.setAddonsForGo)` - (HerokuPostgres.on)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForGo");

				port(HerokuBuildpackConnector.class, "setAddonsForGo").accepts(HerokuPostgresConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForGo");

		// connector_30:(HerokuBuildpack.setAddonsForJava)` - (HerokuClearDBMySQL.on)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForJava");

				port(HerokuBuildpackConnector.class, "setAddonsForJava").accepts(HerokuClearDBMySQLConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForJava");

		// connector_31:(HerokuBuildpack.setAddonsForScala)` - (HerokuClearDBMySQL.on)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForScala");

				port(HerokuBuildpackConnector.class, "setAddonsForScala").accepts(HerokuClearDBMySQLConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForScala");

		// connector_32:(HerokuBuildpack.setAddonsForPython)` - (HerokuClearDBMySQL.on)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForPython");

				port(HerokuBuildpackConnector.class, "setAddonsForPython").accepts(HerokuClearDBMySQLConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForPython");

		// connector_33:(HerokuBuildpack.setAddonsForRuby)` - (HerokuClearDBMySQL.on)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForRuby");

				port(HerokuBuildpackConnector.class, "setAddonsForRuby").accepts(HerokuClearDBMySQLConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForRuby");

		// connector_34:(HerokuBuildpack.setAddonsForNodejs)` - (HerokuClearDBMySQL.on)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForNodejs");

				port(HerokuBuildpackConnector.class, "setAddonsForNodejs").accepts(HerokuClearDBMySQLConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForNodejs");

		// connector_35:(HerokuBuildpack.setAddonsForClojure)` - (HerokuClearDBMySQL.on)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForClojure");

				port(HerokuBuildpackConnector.class, "setAddonsForClojure").accepts(HerokuClearDBMySQLConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForClojure");

		// connector_36:(HerokuBuildpack.setAddonsForGradle)` - (HerokuClearDBMySQL.off)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForGradle");

				port(HerokuBuildpackConnector.class, "setAddonsForGradle").accepts(HerokuClearDBMySQLConnector.class, "off");
				port(HerokuClearDBMySQLConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForGradle");

		// connector_37:(HerokuBuildpack.setAddonsForJvm)` - (HerokuClearDBMySQL.on)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForJvm");

				port(HerokuBuildpackConnector.class, "setAddonsForJvm").accepts(HerokuClearDBMySQLConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForJvm");

		// connector_38:(HerokuBuildpack.setAddonsForPhp)` - (HerokuClearDBMySQL.on)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForPhp");

				port(HerokuBuildpackConnector.class, "setAddonsForPhp").accepts(HerokuClearDBMySQLConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForPhp");

		// connector_39:(HerokuBuildpack.setAddonsForGo)` - (HerokuClearDBMySQL.on)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForGo");

				port(HerokuBuildpackConnector.class, "setAddonsForGo").accepts(HerokuClearDBMySQLConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForGo");

		// connector_40:(HerokuBuildpack.setAddonsForJava)` - (HerokuScoutAPM.off)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForJava");

				port(HerokuBuildpackConnector.class, "setAddonsForJava").accepts(HerokuScoutAPMConnector.class, "off");
				port(HerokuScoutAPMConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForJava");

		// connector_41:(HerokuBuildpack.setAddonsForScala)` - (HerokuScoutAPM.off)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForScala");

				port(HerokuBuildpackConnector.class, "setAddonsForScala").accepts(HerokuScoutAPMConnector.class, "off");
				port(HerokuScoutAPMConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForScala");

		// connector_42:(HerokuBuildpack.setAddonsForPython)` - (HerokuScoutAPM.on)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForPython");

				port(HerokuBuildpackConnector.class, "setAddonsForPython").accepts(HerokuScoutAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForPython");

		// connector_43:(HerokuBuildpack.setAddonsForRuby)` - (HerokuScoutAPM.on)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForRuby");

				port(HerokuBuildpackConnector.class, "setAddonsForRuby").accepts(HerokuScoutAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForRuby");

		// connector_44:(HerokuBuildpack.setAddonsForNodejs)` - (HerokuScoutAPM.off)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForNodejs");

				port(HerokuBuildpackConnector.class, "setAddonsForNodejs").accepts(HerokuScoutAPMConnector.class, "off");
				port(HerokuScoutAPMConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForNodejs");

		// connector_45:(HerokuBuildpack.setAddonsForClojure)` - (HerokuScoutAPM.off)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForClojure");

				port(HerokuBuildpackConnector.class, "setAddonsForClojure").accepts(HerokuScoutAPMConnector.class, "off");
				port(HerokuScoutAPMConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForClojure");

		// connector_46:(HerokuBuildpack.setAddonsForGradle)` - (HerokuScoutAPM.off)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForGradle");

				port(HerokuBuildpackConnector.class, "setAddonsForGradle").accepts(HerokuScoutAPMConnector.class, "off");
				port(HerokuScoutAPMConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForGradle");

		// connector_47:(HerokuBuildpack.setAddonsForJvm)` - (HerokuScoutAPM.off)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForJvm");

				port(HerokuBuildpackConnector.class, "setAddonsForJvm").accepts(HerokuScoutAPMConnector.class, "off");
				port(HerokuScoutAPMConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForJvm");

		// connector_48:(HerokuBuildpack.setAddonsForPhp)` - (HerokuScoutAPM.on)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForPhp");

				port(HerokuBuildpackConnector.class, "setAddonsForPhp").accepts(HerokuScoutAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForPhp");

		// connector_49:(HerokuBuildpack.setAddonsForGo)` - (HerokuScoutAPM.off)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForGo");

				port(HerokuBuildpackConnector.class, "setAddonsForGo").accepts(HerokuScoutAPMConnector.class, "off");
				port(HerokuScoutAPMConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForGo");

		// connector_50:(HerokuBuildpack.setAddonsForJava)` - (HerokuNewRelicAPM.on)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForJava");

				port(HerokuBuildpackConnector.class, "setAddonsForJava").accepts(HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForJava");

		// connector_51:(HerokuBuildpack.setAddonsForScala)` - (HerokuNewRelicAPM.off)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForScala");

				port(HerokuBuildpackConnector.class, "setAddonsForScala").accepts(HerokuNewRelicAPMConnector.class, "off");
				port(HerokuNewRelicAPMConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForScala");

		// connector_52:(HerokuBuildpack.setAddonsForPython)` - (HerokuNewRelicAPM.on)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForPython");

				port(HerokuBuildpackConnector.class, "setAddonsForPython").accepts(HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForPython");

		// connector_53:(HerokuBuildpack.setAddonsForRuby)` - (HerokuNewRelicAPM.on)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForRuby");

				port(HerokuBuildpackConnector.class, "setAddonsForRuby").accepts(HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForRuby");

		// connector_54:(HerokuBuildpack.setAddonsForNodejs)` - (HerokuNewRelicAPM.on)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForNodejs");

				port(HerokuBuildpackConnector.class, "setAddonsForNodejs").accepts(HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForNodejs");

		// connector_55:(HerokuBuildpack.setAddonsForClojure)` - (HerokuNewRelicAPM.off)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForClojure");

				port(HerokuBuildpackConnector.class, "setAddonsForClojure").accepts(HerokuNewRelicAPMConnector.class, "off");
				port(HerokuNewRelicAPMConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForClojure");

		// connector_56:(HerokuBuildpack.setAddonsForGradle)` - (HerokuNewRelicAPM.off)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForGradle");

				port(HerokuBuildpackConnector.class, "setAddonsForGradle").accepts(HerokuNewRelicAPMConnector.class, "off");
				port(HerokuNewRelicAPMConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForGradle");

		// connector_57:(HerokuBuildpack.setAddonsForJvm)` - (HerokuNewRelicAPM.on)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForJvm");

				port(HerokuBuildpackConnector.class, "setAddonsForJvm").accepts(HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForJvm");

		// connector_58:(HerokuBuildpack.setAddonsForPhp)` - (HerokuNewRelicAPM.on)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "on").requires(HerokuBuildpackConnector.class, "setAddonsForPhp");

				port(HerokuBuildpackConnector.class, "setAddonsForPhp").accepts(HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(HerokuBuildpackConnector.class, "setAddonsForPhp");

		// connector_59:(HerokuBuildpack.setAddonsForGo)` - (HerokuNewRelicAPM.off)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "off").requires(HerokuBuildpackConnector.class, "setAddonsForGo");

				port(HerokuBuildpackConnector.class, "setAddonsForGo").accepts(HerokuNewRelicAPMConnector.class, "off");
				port(HerokuNewRelicAPMConnector.class, "off").accepts(HerokuBuildpackConnector.class, "setAddonsForGo");

		// connector_60:[(Deployer.setAddonsForJava) - (HerokuClearDBMySQL.on) - (HerokuPostgres.on) - (HerokuScoutAPM.off) - (HerokuNewRelicAPM.on)]` - (HerokuBuildpack.setAddonsForJava)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "setAddonsForJava").requires(DeployerConnector.class, "setAddonsForJava", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
		//ALL Synchron: c00.null
				port(DeployerConnector.class, "setAddonsForJava").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").requires(DeployerConnector.class, "setAddonsForJava", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").requires(DeployerConnector.class, "setAddonsForJava", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "off").requires(DeployerConnector.class, "setAddonsForJava", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").requires(DeployerConnector.class, "setAddonsForJava", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off");

				port(DeployerConnector.class, "setAddonsForJava").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForJava");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForJava", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForJava");
				port(HerokuPostgresConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForJava", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForJava");
				port(HerokuScoutAPMConnector.class, "off").accepts(DeployerConnector.class, "setAddonsForJava", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForJava");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForJava", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuBuildpackConnector.class, "setAddonsForJava");
				port(HerokuBuildpackConnector.class, "setAddonsForJava").accepts(DeployerConnector.class, "setAddonsForJava", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");

		// connector_61:[(Deployer.setAddonsForScala) - (HerokuClearDBMySQL.on) - (HerokuPostgres.on) - (HerokuScoutAPM.off) - (HerokuNewRelicAPM.on)]` - (HerokuBuildpack.setAddonsForScala)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "setAddonsForScala").requires(DeployerConnector.class, "setAddonsForScala", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
		//ALL Synchron: c00.null
				port(DeployerConnector.class, "setAddonsForScala").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").requires(DeployerConnector.class, "setAddonsForScala", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").requires(DeployerConnector.class, "setAddonsForScala", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "off").requires(DeployerConnector.class, "setAddonsForScala", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").requires(DeployerConnector.class, "setAddonsForScala", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off");

				port(DeployerConnector.class, "setAddonsForScala").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForScala");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForScala", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForScala");
				port(HerokuPostgresConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForScala", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForScala");
				port(HerokuScoutAPMConnector.class, "off").accepts(DeployerConnector.class, "setAddonsForScala", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForScala");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForScala", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuBuildpackConnector.class, "setAddonsForScala");
				port(HerokuBuildpackConnector.class, "setAddonsForScala").accepts(DeployerConnector.class, "setAddonsForScala", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");

		// connector_62:[(Deployer.setAddonsForPython) - (HerokuClearDBMySQL.on) - (HerokuPostgres.on) - (HerokuScoutAPM.off) - (HerokuNewRelicAPM.on)]` - (HerokuBuildpack.setAddonsForPython)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "setAddonsForPython").requires(DeployerConnector.class, "setAddonsForPython", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
		//ALL Synchron: c00.null
				port(DeployerConnector.class, "setAddonsForPython").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").requires(DeployerConnector.class, "setAddonsForPython", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").requires(DeployerConnector.class, "setAddonsForPython", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "off").requires(DeployerConnector.class, "setAddonsForPython", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").requires(DeployerConnector.class, "setAddonsForPython", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off");

				port(DeployerConnector.class, "setAddonsForPython").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForPython");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForPython", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForPython");
				port(HerokuPostgresConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForPython", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForPython");
				port(HerokuScoutAPMConnector.class, "off").accepts(DeployerConnector.class, "setAddonsForPython", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForPython");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForPython", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuBuildpackConnector.class, "setAddonsForPython");
				port(HerokuBuildpackConnector.class, "setAddonsForPython").accepts(DeployerConnector.class, "setAddonsForPython", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");

		// connector_63:[(Deployer.setAddonsForRuby) - (HerokuClearDBMySQL.on) - (HerokuPostgres.on) - (HerokuScoutAPM.off) - (HerokuNewRelicAPM.on)]` - (HerokuBuildpack.setAddonsForRuby)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "setAddonsForRuby").requires(DeployerConnector.class, "setAddonsForRuby", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
		//ALL Synchron: c00.null
				port(DeployerConnector.class, "setAddonsForRuby").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").requires(DeployerConnector.class, "setAddonsForRuby", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").requires(DeployerConnector.class, "setAddonsForRuby", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "off").requires(DeployerConnector.class, "setAddonsForRuby", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").requires(DeployerConnector.class, "setAddonsForRuby", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off");

				port(DeployerConnector.class, "setAddonsForRuby").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForRuby");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForRuby", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForRuby");
				port(HerokuPostgresConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForRuby", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForRuby");
				port(HerokuScoutAPMConnector.class, "off").accepts(DeployerConnector.class, "setAddonsForRuby", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForRuby");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForRuby", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuBuildpackConnector.class, "setAddonsForRuby");
				port(HerokuBuildpackConnector.class, "setAddonsForRuby").accepts(DeployerConnector.class, "setAddonsForRuby", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");

		// connector_64:[(Deployer.setAddonsForNodejs) - (HerokuClearDBMySQL.on) - (HerokuPostgres.on) - (HerokuScoutAPM.off) - (HerokuNewRelicAPM.on)]` - (HerokuBuildpack.setAddonsForNodejs)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "setAddonsForNodejs").requires(DeployerConnector.class, "setAddonsForNodejs", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
		//ALL Synchron: c00.null
				port(DeployerConnector.class, "setAddonsForNodejs").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").requires(DeployerConnector.class, "setAddonsForNodejs", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").requires(DeployerConnector.class, "setAddonsForNodejs", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "off").requires(DeployerConnector.class, "setAddonsForNodejs", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").requires(DeployerConnector.class, "setAddonsForNodejs", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off");

				port(DeployerConnector.class, "setAddonsForNodejs").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForNodejs");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForNodejs", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForNodejs");
				port(HerokuPostgresConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForNodejs", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForNodejs");
				port(HerokuScoutAPMConnector.class, "off").accepts(DeployerConnector.class, "setAddonsForNodejs", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForNodejs");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForNodejs", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuBuildpackConnector.class, "setAddonsForNodejs");
				port(HerokuBuildpackConnector.class, "setAddonsForNodejs").accepts(DeployerConnector.class, "setAddonsForNodejs", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");

		// connector_65:[(Deployer.setAddonsForClojure) - (HerokuClearDBMySQL.on) - (HerokuPostgres.on) - (HerokuScoutAPM.off) - (HerokuNewRelicAPM.on)]` - (HerokuBuildpack.setAddonsForClojure)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "setAddonsForClojure").requires(DeployerConnector.class, "setAddonsForClojure", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
		//ALL Synchron: c00.null
				port(DeployerConnector.class, "setAddonsForClojure").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").requires(DeployerConnector.class, "setAddonsForClojure", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").requires(DeployerConnector.class, "setAddonsForClojure", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "off").requires(DeployerConnector.class, "setAddonsForClojure", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").requires(DeployerConnector.class, "setAddonsForClojure", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off");

				port(DeployerConnector.class, "setAddonsForClojure").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForClojure");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForClojure", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForClojure");
				port(HerokuPostgresConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForClojure", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForClojure");
				port(HerokuScoutAPMConnector.class, "off").accepts(DeployerConnector.class, "setAddonsForClojure", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForClojure");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForClojure", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuBuildpackConnector.class, "setAddonsForClojure");
				port(HerokuBuildpackConnector.class, "setAddonsForClojure").accepts(DeployerConnector.class, "setAddonsForClojure", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");

		// connector_66:[(Deployer.setAddonsForGradle) - (HerokuClearDBMySQL.on) - (HerokuPostgres.on) - (HerokuScoutAPM.off) - (HerokuNewRelicAPM.on)]` - (HerokuBuildpack.setAddonsForGradle)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "setAddonsForGradle").requires(DeployerConnector.class, "setAddonsForGradle", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
		//ALL Synchron: c00.null
				port(DeployerConnector.class, "setAddonsForGradle").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").requires(DeployerConnector.class, "setAddonsForGradle", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").requires(DeployerConnector.class, "setAddonsForGradle", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "off").requires(DeployerConnector.class, "setAddonsForGradle", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").requires(DeployerConnector.class, "setAddonsForGradle", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off");

				port(DeployerConnector.class, "setAddonsForGradle").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForGradle");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForGradle", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForGradle");
				port(HerokuPostgresConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForGradle", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForGradle");
				port(HerokuScoutAPMConnector.class, "off").accepts(DeployerConnector.class, "setAddonsForGradle", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForGradle");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForGradle", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuBuildpackConnector.class, "setAddonsForGradle");
				port(HerokuBuildpackConnector.class, "setAddonsForGradle").accepts(DeployerConnector.class, "setAddonsForGradle", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");

		// connector_67:[(Deployer.setAddonsForJvm) - (HerokuClearDBMySQL.on) - (HerokuPostgres.on) - (HerokuScoutAPM.off) - (HerokuNewRelicAPM.on)]` - (HerokuBuildpack.setAddonsForJvm)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "setAddonsForJvm").requires(DeployerConnector.class, "setAddonsForJvm", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
		//ALL Synchron: c00.null
				port(DeployerConnector.class, "setAddonsForJvm").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").requires(DeployerConnector.class, "setAddonsForJvm", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").requires(DeployerConnector.class, "setAddonsForJvm", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "off").requires(DeployerConnector.class, "setAddonsForJvm", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").requires(DeployerConnector.class, "setAddonsForJvm", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off");

				port(DeployerConnector.class, "setAddonsForJvm").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForJvm");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForJvm", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForJvm");
				port(HerokuPostgresConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForJvm", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForJvm");
				port(HerokuScoutAPMConnector.class, "off").accepts(DeployerConnector.class, "setAddonsForJvm", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForJvm");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForJvm", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuBuildpackConnector.class, "setAddonsForJvm");
				port(HerokuBuildpackConnector.class, "setAddonsForJvm").accepts(DeployerConnector.class, "setAddonsForJvm", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");

		// connector_68:[(Deployer.setAddonsForPhp) - (HerokuClearDBMySQL.on) - (HerokuPostgres.on) - (HerokuScoutAPM.off) - (HerokuNewRelicAPM.on)]` - (HerokuBuildpack.setAddonsForPhp)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "setAddonsForPhp").requires(DeployerConnector.class, "setAddonsForPhp", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
		//ALL Synchron: c00.null
				port(DeployerConnector.class, "setAddonsForPhp").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").requires(DeployerConnector.class, "setAddonsForPhp", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").requires(DeployerConnector.class, "setAddonsForPhp", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "off").requires(DeployerConnector.class, "setAddonsForPhp", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").requires(DeployerConnector.class, "setAddonsForPhp", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off");

				port(DeployerConnector.class, "setAddonsForPhp").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForPhp");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForPhp", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForPhp");
				port(HerokuPostgresConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForPhp", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForPhp");
				port(HerokuScoutAPMConnector.class, "off").accepts(DeployerConnector.class, "setAddonsForPhp", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForPhp");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForPhp", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuBuildpackConnector.class, "setAddonsForPhp");
				port(HerokuBuildpackConnector.class, "setAddonsForPhp").accepts(DeployerConnector.class, "setAddonsForPhp", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");

		// connector_69:[(Deployer.setAddonsForGo) - (HerokuClearDBMySQL.on) - (HerokuPostgres.on) - (HerokuScoutAPM.off) - (HerokuNewRelicAPM.on)]` - (HerokuBuildpack.setAddonsForGo)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "setAddonsForGo").requires(DeployerConnector.class, "setAddonsForGo", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
		//ALL Synchron: c00.null
				port(DeployerConnector.class, "setAddonsForGo").requires(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuClearDBMySQLConnector.class, "on").requires(DeployerConnector.class, "setAddonsForGo", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuPostgresConnector.class, "on").requires(DeployerConnector.class, "setAddonsForGo", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuScoutAPMConnector.class, "off").requires(DeployerConnector.class, "setAddonsForGo", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on");
				port(HerokuNewRelicAPMConnector.class, "on").requires(DeployerConnector.class, "setAddonsForGo", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off");

				port(DeployerConnector.class, "setAddonsForGo").accepts(HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForGo");
				port(HerokuClearDBMySQLConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForGo", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForGo");
				port(HerokuPostgresConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForGo", HerokuClearDBMySQLConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForGo");
				port(HerokuScoutAPMConnector.class, "off").accepts(DeployerConnector.class, "setAddonsForGo", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuNewRelicAPMConnector.class, "on", HerokuBuildpackConnector.class, "setAddonsForGo");
				port(HerokuNewRelicAPMConnector.class, "on").accepts(DeployerConnector.class, "setAddonsForGo", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuBuildpackConnector.class, "setAddonsForGo");
				port(HerokuBuildpackConnector.class, "setAddonsForGo").accepts(DeployerConnector.class, "setAddonsForGo", HerokuClearDBMySQLConnector.class, "on", HerokuPostgresConnector.class, "on", HerokuScoutAPMConnector.class, "off", HerokuNewRelicAPMConnector.class, "on");

		// connector_70:(HerokuBuildpack.setAddonsForJava)` - (Deployer.setAddonsForJava)
		//Synchron & Trigger
				port(DeployerConnector.class, "setAddonsForJava").requires(HerokuBuildpackConnector.class, "setAddonsForJava");

				port(HerokuBuildpackConnector.class, "setAddonsForJava").accepts(DeployerConnector.class, "setAddonsForJava");
				port(DeployerConnector.class, "setAddonsForJava").accepts(HerokuBuildpackConnector.class, "setAddonsForJava");

		// connector_71:(HerokuBuildpack.setAddonsForScala)` - (Deployer.setAddonsForScala)
		//Synchron & Trigger
				port(DeployerConnector.class, "setAddonsForScala").requires(HerokuBuildpackConnector.class, "setAddonsForScala");

				port(HerokuBuildpackConnector.class, "setAddonsForScala").accepts(DeployerConnector.class, "setAddonsForScala");
				port(DeployerConnector.class, "setAddonsForScala").accepts(HerokuBuildpackConnector.class, "setAddonsForScala");

		// connector_72:(HerokuBuildpack.setAddonsForPython)` - (Deployer.setAddonsForPython)
		//Synchron & Trigger
				port(DeployerConnector.class, "setAddonsForPython").requires(HerokuBuildpackConnector.class, "setAddonsForPython");

				port(HerokuBuildpackConnector.class, "setAddonsForPython").accepts(DeployerConnector.class, "setAddonsForPython");
				port(DeployerConnector.class, "setAddonsForPython").accepts(HerokuBuildpackConnector.class, "setAddonsForPython");

		// connector_73:(HerokuBuildpack.setAddonsForRuby)` - (Deployer.setAddonsForRuby)
		//Synchron & Trigger
				port(DeployerConnector.class, "setAddonsForRuby").requires(HerokuBuildpackConnector.class, "setAddonsForRuby");

				port(HerokuBuildpackConnector.class, "setAddonsForRuby").accepts(DeployerConnector.class, "setAddonsForRuby");
				port(DeployerConnector.class, "setAddonsForRuby").accepts(HerokuBuildpackConnector.class, "setAddonsForRuby");

		// connector_74:(HerokuBuildpack.setAddonsForNodejs)` - (Deployer.setAddonsForNodejs)
		//Synchron & Trigger
				port(DeployerConnector.class, "setAddonsForNodejs").requires(HerokuBuildpackConnector.class, "setAddonsForNodejs");

				port(HerokuBuildpackConnector.class, "setAddonsForNodejs").accepts(DeployerConnector.class, "setAddonsForNodejs");
				port(DeployerConnector.class, "setAddonsForNodejs").accepts(HerokuBuildpackConnector.class, "setAddonsForNodejs");

		// connector_75:(HerokuBuildpack.setAddonsForClojure)` - (Deployer.setAddonsForClojure)
		//Synchron & Trigger
				port(DeployerConnector.class, "setAddonsForClojure").requires(HerokuBuildpackConnector.class, "setAddonsForClojure");

				port(HerokuBuildpackConnector.class, "setAddonsForClojure").accepts(DeployerConnector.class, "setAddonsForClojure");
				port(DeployerConnector.class, "setAddonsForClojure").accepts(HerokuBuildpackConnector.class, "setAddonsForClojure");

		// connector_76:(HerokuBuildpack.setAddonsForGradle)` - (Deployer.setAddonsForGradle)
		//Synchron & Trigger
				port(DeployerConnector.class, "setAddonsForGradle").requires(HerokuBuildpackConnector.class, "setAddonsForGradle");

				port(HerokuBuildpackConnector.class, "setAddonsForGradle").accepts(DeployerConnector.class, "setAddonsForGradle");
				port(DeployerConnector.class, "setAddonsForGradle").accepts(HerokuBuildpackConnector.class, "setAddonsForGradle");

		// connector_77:(HerokuBuildpack.setAddonsForJvm)` - (Deployer.setAddonsForJvm)
		//Synchron & Trigger
				port(DeployerConnector.class, "setAddonsForJvm").requires(HerokuBuildpackConnector.class, "setAddonsForJvm");

				port(HerokuBuildpackConnector.class, "setAddonsForJvm").accepts(DeployerConnector.class, "setAddonsForJvm");
				port(DeployerConnector.class, "setAddonsForJvm").accepts(HerokuBuildpackConnector.class, "setAddonsForJvm");

		// connector_78:(HerokuBuildpack.setAddonsForPhp)` - (Deployer.setAddonsForPhp)
		//Synchron & Trigger
				port(DeployerConnector.class, "setAddonsForPhp").requires(HerokuBuildpackConnector.class, "setAddonsForPhp");

				port(HerokuBuildpackConnector.class, "setAddonsForPhp").accepts(DeployerConnector.class, "setAddonsForPhp");
				port(DeployerConnector.class, "setAddonsForPhp").accepts(HerokuBuildpackConnector.class, "setAddonsForPhp");

		// connector_79:(HerokuBuildpack.setAddonsForGo)` - (Deployer.setAddonsForGo)
		//Synchron & Trigger
				port(DeployerConnector.class, "setAddonsForGo").requires(HerokuBuildpackConnector.class, "setAddonsForGo");

				port(HerokuBuildpackConnector.class, "setAddonsForGo").accepts(DeployerConnector.class, "setAddonsForGo");
				port(DeployerConnector.class, "setAddonsForGo").accepts(HerokuBuildpackConnector.class, "setAddonsForGo");

		// connector_80:(HerokuPostgres.sendAddonResponse)` - (Deployer.receiveAddonResponse)
		//Synchron & Trigger
				port(DeployerConnector.class, "receiveAddonResponse").requires(HerokuPostgresConnector.class, "sendAddonResponse");

				port(HerokuPostgresConnector.class, "sendAddonResponse").accepts(DeployerConnector.class, "receiveAddonResponse");
				port(DeployerConnector.class, "receiveAddonResponse").accepts(HerokuPostgresConnector.class, "sendAddonResponse");

		// connector_81:(Deployer.addHerokuPostgres1)` - (HerokuPostgres.sub1)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "sub1").requires(DeployerConnector.class, "addHerokuPostgres1");

				port(DeployerConnector.class, "addHerokuPostgres1").accepts(HerokuPostgresConnector.class, "sub1");
				port(HerokuPostgresConnector.class, "sub1").accepts(DeployerConnector.class, "addHerokuPostgres1");

		// connector_81a:(Deployer.addMorePostgres)` - (HerokuPostgres.sub1)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "sub1").requires(DeployerConnector.class, "addMorePostgres");

				port(DeployerConnector.class, "addMorePostgres").accepts(HerokuPostgresConnector.class, "sub1");
				port(HerokuPostgresConnector.class, "sub1").accepts(DeployerConnector.class, "addMorePostgres");
		// connector_82:(Deployer.addHerokuPostgres2)` - (HerokuPostgres.sub2)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "sub2").requires(DeployerConnector.class, "addHerokuPostgres2");

				port(DeployerConnector.class, "addHerokuPostgres2").accepts(HerokuPostgresConnector.class, "sub2");
				port(HerokuPostgresConnector.class, "sub2").accepts(DeployerConnector.class, "addHerokuPostgres2");

		// connector_83:(Deployer.addClearDBMySQL1)` - (HerokuClearDBMySQL.sub1)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "sub1").requires(DeployerConnector.class, "addClearDBMySQL1");

				port(DeployerConnector.class, "addClearDBMySQL1").accepts(HerokuClearDBMySQLConnector.class, "sub1");
				port(HerokuClearDBMySQLConnector.class, "sub1").accepts(DeployerConnector.class, "addClearDBMySQL1");

		// connector_84:(Deployer.addScoutAPM1)` - (HerokuScoutAPM.sub1)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "sub1").requires(DeployerConnector.class, "addScoutAPM1");

				port(DeployerConnector.class, "addScoutAPM1").accepts(HerokuScoutAPMConnector.class, "sub1");
				port(HerokuScoutAPMConnector.class, "sub1").accepts(DeployerConnector.class, "addScoutAPM1");

		// connector_85:(Deployer.addNewRelicAPM1)` - (HerokuNewRelicAPM.sub1)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "sub1").requires(DeployerConnector.class, "addNewRelicAPM1");

				port(DeployerConnector.class, "addNewRelicAPM1").accepts(HerokuNewRelicAPMConnector.class, "sub1");
				port(HerokuNewRelicAPMConnector.class, "sub1").accepts(DeployerConnector.class, "addNewRelicAPM1");

		// connector_86:(Deployer.resetAll)` - (HerokuDynoType.reset1)
		//Synchron & Trigger
				port(HerokuDynoTypeConnector.class, "reset1").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuDynoTypeConnector.class, "reset1");
				port(HerokuDynoTypeConnector.class, "reset1").accepts(DeployerConnector.class, "resetAll");

		// connector_87:(Deployer.resetAll)` - (HerokuRegion.USreset)
		//Synchron & Trigger
				port(HerokuRegionConnector.class, "USreset").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuRegionConnector.class, "USreset");
				port(HerokuRegionConnector.class, "USreset").accepts(DeployerConnector.class, "resetAll");

		// connector_88:(Deployer.resetAll)` - (HerokuRegion.EUreset)
		//Synchron & Trigger
				port(HerokuRegionConnector.class, "EUreset").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuRegionConnector.class, "EUreset");
				port(HerokuRegionConnector.class, "EUreset").accepts(DeployerConnector.class, "resetAll");

		// connector_89:(Deployer.resetAll)` - (HerokuBuildpack.removeJava)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "removeJava").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuBuildpackConnector.class, "removeJava");
				port(HerokuBuildpackConnector.class, "removeJava").accepts(DeployerConnector.class, "resetAll");

		// connector_90:(Deployer.resetAll)` - (HerokuBuildpack.removeScala)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "removeScala").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuBuildpackConnector.class, "removeScala");
				port(HerokuBuildpackConnector.class, "removeScala").accepts(DeployerConnector.class, "resetAll");

		// connector_91:(Deployer.resetAll)` - (HerokuBuildpack.removeJvm)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "removeJvm").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuBuildpackConnector.class, "removeJvm");
				port(HerokuBuildpackConnector.class, "removeJvm").accepts(DeployerConnector.class, "resetAll");

		// connector_92:(Deployer.resetAll)` - (HerokuBuildpack.removePython)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "removePython").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuBuildpackConnector.class, "removePython");
				port(HerokuBuildpackConnector.class, "removePython").accepts(DeployerConnector.class, "resetAll");

		// connector_93:(Deployer.resetAll)` - (HerokuBuildpack.removeRuby)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "removeRuby").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuBuildpackConnector.class, "removeRuby");
				port(HerokuBuildpackConnector.class, "removeRuby").accepts(DeployerConnector.class, "resetAll");

		// connector_94:(Deployer.resetAll)` - (HerokuBuildpack.removeNodejs)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "removeNodejs").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuBuildpackConnector.class, "removeNodejs");
				port(HerokuBuildpackConnector.class, "removeNodejs").accepts(DeployerConnector.class, "resetAll");

		// connector_95:(Deployer.resetAll)` - (HerokuBuildpack.removeClojure)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "removeClojure").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuBuildpackConnector.class, "removeClojure");
				port(HerokuBuildpackConnector.class, "removeClojure").accepts(DeployerConnector.class, "resetAll");

		// connector_96:(Deployer.resetAll)` - (HerokuBuildpack.removeGradle)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "removeGradle").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuBuildpackConnector.class, "removeGradle");
				port(HerokuBuildpackConnector.class, "removeGradle").accepts(DeployerConnector.class, "resetAll");

		// connector_97:(Deployer.resetAll)` - (HerokuBuildpack.removePhp)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "removePhp").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuBuildpackConnector.class, "removePhp");
				port(HerokuBuildpackConnector.class, "removePhp").accepts(DeployerConnector.class, "resetAll");

		// connector_98:(Deployer.resetAll)` - (HerokuBuildpack.removeGo)
		//Synchron & Trigger
				port(HerokuBuildpackConnector.class, "removeGo").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuBuildpackConnector.class, "removeGo");
				port(HerokuBuildpackConnector.class, "removeGo").accepts(DeployerConnector.class, "resetAll");

		// connector_99:(Deployer.resetAll)` - (HerokuPostgres.off)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "off").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuPostgresConnector.class, "off");
				port(HerokuPostgresConnector.class, "off").accepts(DeployerConnector.class, "resetAll");

		// connector_100:(Deployer.resetAll)` - (HerokuPostgres.reset1)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "reset1").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuPostgresConnector.class, "reset1");
				port(HerokuPostgresConnector.class, "reset1").accepts(DeployerConnector.class, "resetAll");

		// connector_101:(Deployer.resetAll)` - (HerokuPostgres.reset2)
		//Synchron & Trigger
				port(HerokuPostgresConnector.class, "reset2").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuPostgresConnector.class, "reset2");
				port(HerokuPostgresConnector.class, "reset2").accepts(DeployerConnector.class, "resetAll");

		// connector_102:(Deployer.resetAll)` - (HerokuClearDBMySQL.off)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "off").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuClearDBMySQLConnector.class, "off");
				port(HerokuClearDBMySQLConnector.class, "off").accepts(DeployerConnector.class, "resetAll");

		// connector_103:(Deployer.resetAll)` - (HerokuClearDBMySQL.reset1)
		//Synchron & Trigger
				port(HerokuClearDBMySQLConnector.class, "reset1").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuClearDBMySQLConnector.class, "reset1");
				port(HerokuClearDBMySQLConnector.class, "reset1").accepts(DeployerConnector.class, "resetAll");

		// connector_104:(Deployer.resetAll)` - (HerokuScoutAPM.off)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "off").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuScoutAPMConnector.class, "off");
				port(HerokuScoutAPMConnector.class, "off").accepts(DeployerConnector.class, "resetAll");

		// connector_105:(Deployer.resetAll)` - (HerokuScoutAPM.reset1)
		//Synchron & Trigger
				port(HerokuScoutAPMConnector.class, "reset1").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuScoutAPMConnector.class, "reset1");
				port(HerokuScoutAPMConnector.class, "reset1").accepts(DeployerConnector.class, "resetAll");

		// connector_106:(Deployer.resetAll)` - (HerokuNewRelicAPM.off)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "off").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuNewRelicAPMConnector.class, "off");
				port(HerokuNewRelicAPMConnector.class, "off").accepts(DeployerConnector.class, "resetAll");

		// connector_107:(Deployer.resetAll)` - (HerokuNewRelicAPM.reset1)
		//Synchron & Trigger
				port(HerokuNewRelicAPMConnector.class, "reset1").requires(DeployerConnector.class, "resetAll");

				port(DeployerConnector.class, "resetAll").accepts(HerokuNewRelicAPMConnector.class, "reset1");
				port(HerokuNewRelicAPMConnector.class, "reset1").accepts(DeployerConnector.class, "resetAll");

				data(DeployerConnector.class, "DynoOptions").to(HerokuDynoTypeConnector.class, "DynoOptions");
				data(HerokuDynoTypeConnector.class, "DynoResponseData").to(DeployerConnector.class, "DynoResponseData");
				data(DeployerConnector.class, "AppName").to(HerokuBuildpackConnector.class, "AppName");
				data(DeployerConnector.class, "AppName").to(HerokuPostgresConnector.class, "AppName");
				data(HerokuPostgresConnector.class, "AddonResponse").to(DeployerConnector.class, "AddonResponse");

	}
}
