pipeline{
    agent any
    stages{
        stage("Run command"){
            steps{
                sh '''
                echo Hello
                yum install httpd -y
                ping -c 4 google.com
                '''
            }
        }
    }
}