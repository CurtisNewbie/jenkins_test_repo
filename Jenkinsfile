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
                bat 'javac ComplexApplication.java'
            }
        }
        stage('Run'){
            steps{
                echo 'CI - Running Package'
                bat 'java ComplexApplication'
            }
        }
    }

}