pipeline {
    agent any
    environment{
        // declare environment variables
        JOB_NAME = 'Pipeline for testable_app'
        TARGET_BRANCH = 'stable'
    }
    stages {
        stage('Init'){
            steps{
                echo JOB_NAME
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
                withCredentials([usernamePassword(credentialsId: 'repoCredentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){

                bat('''
                    git config --local credential.helper "!f() { echo username=\\$USERNAME; echo password=\\$PASSWORD; }; f"
                    git push origin HEAD:$TARGET_BRANCH
                ''')
                }
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
