pipeline {
    agent any
    environment{
        // declare environment variables
        JOB_NAME = 'Pipeline for testable_app'
        STABLE_BRANCH_NAME = 'stable'
        DEV_BRANCH_NAME = 'origin/dev'
    }
    stages {
        stage('Init'){
            steps{
                // TODO: doesn't seem to work
                // when{
                //     // only when something changed
                //     changeset "*"
                // }
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
                bat "git switch $STABLE_BRANCH_NAME"
                bat "git merge $DEV_BRANCH_NAME" 
                bat "git push"
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
