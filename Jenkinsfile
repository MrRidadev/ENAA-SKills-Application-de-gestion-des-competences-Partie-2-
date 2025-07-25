pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build & Run Tests') {
            steps {
                sh 'mvn clean install'
            }
        }

        // SONARQUBE STAGE IS REMOVED

        stage('Build Docker Images') {
            steps {
                script {
                    echo 'Building Docker images...'
                    sh 'docker build -t enaa/auth-service:latest auth-service/'
                    sh 'docker build -t enaa/api-gateway:latest api-gateway/'
                    sh 'docker build -t enaa/eureka-server:latest eureka-server/'
                    // Add a line for each of your other microservices
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}