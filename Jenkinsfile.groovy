pipeline{
    agent any
    stages{
        stage("Run command"){
            steps{
                sh '''
                set +xe
                echo Hello
                ech Error
                sudo yum install httpd wget unzip -y
                ping -c 4 google.com
                '''
            }
        }
        stage("Download Terraform"){
            steps{
                ws("tmp/"){
                    script{
                        def exists = fileExists 'terraform_0.12.21_linux_amd64.zip'
                        if(exists){
                            sh "unzip terraform_0.12.21_linux_amd64.zip"
                            sh "sudo mv terraform /bin"
                            sh "terraform version"
                        }else{
                            sh "wget https://releases.hashicorp.com/terraform/0.12.21/terraform_0.12.21_linux_amd64.zip"
                            sh "unzip terraform_0.12.21_linux_amd64.zip"
                            sh "sudo mv terraform /bin"
                            sh "terraform version"
                        }
                    }   
                }
            }
            
        }
        stage("Write to a file"){
                steps{
                    ws("tmp/"){
                        writeFile text: "Test", file: "Testfile"
                        sh "cat TestFile"
                    }
                }
            }
        stage("Download Packer"){
            steps{
                ws("tmp/"){
                    script{
                        def exists = fileExists 'packer_1.5.4_linux_amd64.zip'
                        if(exists){
                            sh "unzip -o packer_1.5.4_linux_amd64.zip"
                            sh "sudo mv packer /bin"
                            sh "packer version"
                        }else{
                            sh "wget https://releases.hashicorp.com/packer/1.5.4/packer_1.5.4_linux_amd64.zip"
                            sh "unzip -o packer_1.5.4_linux_amd64.zip"
                            sh "sudo mv packer /bin"
                            sh "packer version"
                        }
                    }   
                }
            }
            
        }
    }
}