pipeline {
    agent any
    environment{
        // declare environment variables
        JOB_NAME = 'Pipeline for testable_app'
    }
    stages {
        stage('Init'){
            steps{
                // display java version
                bat 'java -version'
                bat 'javac -version'
                // display mvn version
                bat 'mvn --version'
                echo JOB_NAME
            }
        }
        stage('Build'){
            steps{
                echo 'CI - Building Package'
                bat 'mvn -f testable_app clean compile'
                // bat 'javac ComplexApplication.java'
            }
        }
        stage('Test'){
            steps{
                echo 'CI - Testing Package'
                bat 'mvn -f testable_app test'
                // bat 'java ComplexApplication'
            }
        }
        stage('Deploy'){
            when{
                expression{
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
            steps{
                bat ''
            }
        }
    }
    // after all stages
    post {
        // only on failure
        failure{
            echo "CI Failed"
        }
        // always do
        always{
            echo "CI Finished"
        }
    }
}
