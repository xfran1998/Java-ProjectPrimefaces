node {

	currentBuild.result = "SUCCESS"

    try {
   
	   def pipelineConfigFile='http://crunch.uv.es/svn/INCITAR_MISCELANEA/Team%20config/Jenkins/config'
	   
	   //El id de las credenciales de acceso al SVN configurado en jenkins
	   def SVNCredentialsId = ''
	   
	   //El id de las credenciales de acceso por clave privada para el SSH
	   def privateKeySSH = 'privateKey_jenkins_smagris2'
	    // Tool name from Jenkins configuration
	    def mavenName =  "Maven 3.6.1"   
	    // Get Artifactory server instance, defined in the Artifactory Plugin administration page.
	    def artifactory = Artifactory.server "artifactoryINCITAR"
	    //def artifactory = Artifactory.newServer url:'http://smagris2.uv.es:8081/artifactory', credentialsId: 'incitarArtifactoryCredential'
	    
	    // Create an Artifactory Maven instance.
	    def rtMaven = Artifactory.newMavenBuild()
	    rtMaven.tool = mavenName
	    
	    def mvnHome = tool mavenName
	    
	    def dirCheckout = "checkout"
	    def dirConfig = "config"
	    def directorioDesplieguesJBoss = ""
	    def dirTarget
	    
	    def pom
	    def pomHijo
	       
	    def buildInfo
	    
	    
	    def props
	    
	    def artefactoVersionAnteriorDesplegado1
		def artefactoVersionAnteriorDesplegado2
		
		def artefactoVersionActual
		
		def desplegables = []
		def poms = []
		def targetDirs = []
			
		def version
		
		jdk = tool name: 'JDK8'
	  	env.JAVA_HOME = "${jdk}"
		
	
	    stage('Descargar fuente') {
	    
	    	echo env.author
	    
	    	checkout([$class: 'GitSCM', branches: [[name: 'main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/xfran1998/Java-ProjectPrimefaces.git']]])
	    }
	   
	    stage('Maven build & artifactory deploy') {
			// Set the working directory to the root of the project
			dir('Java-ProjectPrimefaces') {

			// Run Maven build
			rtMaven.run pom: 'pom.xml', goals: 'clean install -DskipTests=true'
			
			// Collect build information
			buildInfo = rtMaven.collectBuildInfo()
			
			// Deploy artifacts to Artifactory
			artifactory.deploy buildInfo: buildInfo
			}
		}
		stage('SonarQube analysis') {
			environment {
				scannerHome = tool 'SonarQubeScanner'
			}
			steps {
				withSonarQubeEnv('sq1') {
					sh "${scannerHome}/bin/sonar-scanner"
        		}
   			}
		}
  	}
  	catch (err) {

        currentBuild.result = "FAILURE"

        throw err
    }
}