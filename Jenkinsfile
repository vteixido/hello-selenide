pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                sh " ./gradlew clean test check "
            }
            post {
                always {
                    junit 'build/test-results/test/*xml'
                    //jacoco execPattern: 'build/jacoco/*.exec'
                    //recordIssues(
                    //    tools: [
                    //        pmdParser(pattern: 'build/reports/pmd/*.xml')
                    //        //pit(pattern: 'build/reports/pitest/*.xml')
                    //    ]
                    //)
                }
            }
        }
        stage('Build') {
            steps {
                echo 'Build...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
