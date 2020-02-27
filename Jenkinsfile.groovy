pipeline{
    agent any
    stages{
        stage("Run command"){
            steps{
                sh '''
                set +xe
                echo Hello
                ech Error
                sudo yum install httpd wget -y
                ping -c 4 google.com
                '''
            }
        }
        stage("Download Terraform"){
            steps{
                ws("tmp/"){
                    sh "pwd"
                    sh "wget https://releases.hashicorp.com/terraform/0.12.21/terraform_0.12.21_linux_amd64.zip"
                }
            }
        }
    }
}