pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                sh " ./gradlew clean "
            }
        }
        stage('Test') {
            when { expression{false}}
            steps {
               sh "./gradlew test"
               sh "./gradlew testFirefox"
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
        stage('Security') {
            steps {
               sh '/usr/local/bin/trivy fs --format json --output trivy-results.json .'
            }
            post {
                always {
                    recordIssues(tools: [trivy(pattern: 'trivy-results.json')])
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
