pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh '''
                    echo "Building the project..."
                    ./mvnw clean install
                '''
            }
        }
    }
}