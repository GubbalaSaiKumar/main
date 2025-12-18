pipeline {
    agent any
    
    tools {
        maven 'Maven-3.9' // Adjust based on your Jenkins Maven installation name
        jdk 'JDK-17'      // Adjust based on your Jenkins JDK installation name
    }
    
    environment {
        APP_NAME = 'devops-demo-app'
        VERSION = '1.0.0'
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                echo 'Packaging the application...'
                sh 'mvn package -DskipTests'
            }
        }
        
        stage('Archive') {
            steps {
                echo 'Archiving artifacts...'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                // Add your deployment commands here
                // Example: Copy JAR to deployment server, restart service, etc.
                sh '''
                    echo "Deployment would happen here"
                    echo "JAR file: target/${APP_NAME}-${VERSION}.jar"
                '''
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline execution failed!'
        }
        always {
            cleanWs()
        }
    }
}
