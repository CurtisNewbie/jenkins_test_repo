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
                bat 'mvn clean compile'
                // bat 'javac ComplexApplication.java'
            }
        }
        stage('Test'){
            steps{
                echo 'CI - Testing Package'
                bat 'mvn test'
                // bat 'java ComplexApplication'
            }
        }
    }

}