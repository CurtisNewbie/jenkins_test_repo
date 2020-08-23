pipeline {
    agent any
    stages {
        stage('Environment'){
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
    }

}