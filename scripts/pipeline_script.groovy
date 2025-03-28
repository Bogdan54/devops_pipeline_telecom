pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'docker build -t telecom-app .'
            }
        }
        stage('Test') {
            steps {
                sh 'docker run --rm telecom-app pytest'
            }
        }
        stage('Deploy') {
            steps {
                sh 'kubectl apply -f deployment.yaml'
            }
        }
    }
}
