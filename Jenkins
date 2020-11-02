pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
            
                bat 'mvn clean';
                echo 'Project Cleaned';
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test';
                echo 'Project Tested';
            }
        }
        stage('Sonar') {
            steps {
                bat 'mvn sonar:sonar';
                echo 'Sonar is up';
            }
        }
        stage('Package') {
            steps {
                bat 'mvn package';
                echo 'Project packaged';
            }
        }
        stage('Install') {
            steps {
                bat 'mvn install';
                echo 'Project Installed';
            }
        }
        stage('deploy') {
            steps {
                echo 'Project Deployed';
                bat 'mvn clean package deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet -Dversion=4.0 -DgeneratePom=true -Dpackaging=jar  -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-2.0.jar';
            }
        }
        
    }
}
