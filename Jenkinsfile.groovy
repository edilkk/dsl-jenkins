pipeline{
    agent any
    stages{
        stage("Run command"){
            steps{
                sh "echo Hello"
            }
        }
    }
}