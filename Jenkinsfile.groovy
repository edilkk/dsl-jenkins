pipeline{
    agent any
    stages{
        stage("Run command"){
            steps{
                sh '''
                set +xe
                echo Hello
                ech Error
                sudo yum install httpd -y
                ping -c 4 google.com
                '''
            }
        }
    }
}