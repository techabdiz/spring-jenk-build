pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh '''
                    echo "Building the project..."
                    ./mvnw spring-boot:build-image
                '''
            }
        }
        stage('Test') {
            steps {
                sh '''
                    docker images
                '''
            }
        }
    }
}