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
                    docker run --rm -d -p 8080:8080 spring-jenk-build:0.0.1-SNAPSHOT
                    echo "Running tests..."
                    curl http://localhost:8080/hello
                '''
            }
        }
    }
}