pipeline {
    agent any
    environment{
        // declare environment variables
        JOB_NAME = 'Pipeline for testable_app'
        TARGET_BRANCH = 'stable'
        // https://www.jenkins.io/doc/book/pipeline/jenkinsfile/#usernames-and-passwords
        CRED = credentials('global_cred')
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
                // https://support.cloudbees.com/hc/en-us/articles/360027646491-Pipeline-Equivalent-to-Git-Publisher
                bat('''
                    git config --local credential.helper "!f() { echo username=\\$CRED_USR; echo password=\\$CRED_PSW; }; f"
                    git push -u origin/\\$TARGET_BRANCH
                ''')
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
