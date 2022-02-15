pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                sh " ./gradlew clean "
            }
        }
        stage('Test') {
            parallel {
                stage('test: chrome') {
                    steps {
                        sh "./gradlew test"
                    }
                }
                stage("test:firefox") {
                    steps{
                        sh "./gradlew testFirefox"
                    }
                }

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
