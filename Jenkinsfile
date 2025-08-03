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
                    args '-p 3000:3000'
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