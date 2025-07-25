pipeline {
    // This 'agent' directive is essential. It tells Jenkins to run on any available machine.
    agent any



    tools {
        maven 'Maven3'
    }

    // This section contains all the steps the pipeline will execute
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

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonarQubeServer') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('Build Docker Images') {
            steps {
                script {
                    echo 'Building Docker images...'
                    sh 'docker build -t enaa/auth-service:latest auth-service/'
                    sh 'docker build -t enaa/api-gateway:latest api-gateway/'
                    // Add a line for each of your other microservices
                }
            }
        }
    }
}