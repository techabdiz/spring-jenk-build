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
            agent {
                docker {
                    image 'spring-jenk-build:0.0.1-SNAPSHOT'
                }
            }
            steps {
                sh '''
                    echo "Running tests..."
                    curl http://localhost:3000/hello
                '''
            }
        }
    }
}