pipeline {
    agent any
    environment{
        // declare environment variables
        JOB_NAME = 'Pipeline for testable_app'
        // https://www.jenkins.io/doc/book/pipeline/jenkinsfile/#usernames-and-passwords
        // CRED = credentials('global_cred')
        // CRED_USR
        // CRED_PSW
    }
    stages {
        stage('Init'){
            steps{
                // display java version
                bat 'java -version'
                bat 'javac -version'
                // display mvn version
                bat 'mvn --version'
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
                    // SUCCESS build
                    currentBuild.result == null || currentBuild.result == 'SUCCESS' 
                }
                // on 'dev' branch
                branch 'dev'
            }
            steps{
                echo "Deployed..." 
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
            // junit 'build/reports/**/*.xml'
        }
    }
}
