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
                // This MUST be 'sh' because the command runs inside the Linux container
                sh './mvnw clean install'
            }
        }

        stage('Build Docker Images') {
            steps {
                script {
                    echo 'Building Docker image for Brief-Service...'
                    // 'sh' is also correct here
                    sh 'docker build -t enaa/brief-service:latest Brief-Service/'
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