pipeline {
    agent any
    stages {
        stage('init'){
            steps{
                // display java version
                bat 'java -version'
                bat 'javac -version'
                // display mvn version
                bat 'mvn --version'
            }
        }
        stage('build'){
            steps{
                echo 'CI - Building Package'
                bat 'javac Jenkinsfile.java'
            }
        }
        stage('test'){
            steps{
                echo 'CI - Test Package'
                bat 'java Jenkinsfile'
            }
        }
    }

}