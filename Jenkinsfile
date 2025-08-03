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
                    echo "Starting container..."
                    docker run -d -p 3000:3000 --name test-app spring-jenk-build:0.0.1-SNAPSHOT

                    echo "Waiting for app to be ready..."
                    for i in {1..10}; do
                      if curl -s http://localhost:3000/hello; then
                        echo "App is up!"
                        break
                      else
                        echo "Waiting..."
                        sleep 3
                      fi
                    done

                    echo "Running curl test..."
                    curl http://localhost:3000/hello

                    echo "Stopping container..."
                    docker stop test-app
                    docker rm test-app
                '''
            }
        }
    }
}