# keytool 命令

> - [Name](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#name)
> - [Synopsis](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#synopsis)
> - [Description](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#description)
> - [Command and Option Notes](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#command-and-option-notes)
> - [Commands and Options](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-and-options)
> - [Commands for Creating or Adding Data to the Keystore](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-creating-or-adding-data-to-the-keystore)
> - [Commands for Importing Contents from Another Keystore](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-importing-contents-from-another-keystore)
> - [Commands for Generating a Certificate Request](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-generating-a-certificate-request)
> - [Commands for Exporting Data](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-exporting-data)
> - [Commands for Displaying Data](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-displaying-data)
> - [Commands for Managing the Keystore](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-managing-the-keystore)
> - [Commands for Displaying Security-related Information](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-displaying-security-related-information)
> - [Commands for Displaying Program Version](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-displaying-program-version)
> - [Commands for Displaying Help Information](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-displaying-help-information)
> - [Common Command Options](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#common-command-options)
> - [Pre-configured options file](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#pre-configured-options-file)
> - [Examples of Option Values](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#examples-of-option-values)
> - [Supported Named Extensions](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#supported-named-extensions)
> - [Examples of Tasks in Creating a keystore](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#examples-of-tasks-in-creating-a-keystore)
> - [Generating the Key Pair](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#generating-the-key-pair)
> - [Requesting a Signed Certificate from a CA](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#requesting-a-signed-certificate-from-a-ca)
> - [Importing a Certificate for the CA](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#importing-a-certificate-for-the-ca)
> - [Importing the Certificate Reply from the CA](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#importing-the-certificate-reply-from-the-ca)
> - [Exporting a Certificate That Authenticates the Public Key](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#exporting-a-certificate-that-authenticates-the-public-key)
> - [Importing the Keystore](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#importing-the-keystore)
> - [Generating Certificates for an SSL Server](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#generating-certificates-for-an-ssl-server)
> - [Terms](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#terms)
> - [Warnings](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#warnings)
> - [Importing Trusted Certificates Warning](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#importing-trusted-certificates-warning)
> - [Passwords Warning](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#passwords-warning)
> - [Certificate Conformance Warning](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#certificate-conformance-warning)
> - [Import a New Trusted Certificate](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#import-a-new-trusted-certificate)
> - [Import a Certificate Reply](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#import-a-certificate-reply)

## 名字

keytool - 密钥和证书管理实用程序
## 概要
keytool [commands]

commands
keytool 的命令包括：

> - `-certreq`: 生成证书请求
> - `-changealias`: 更改条目的别名
> - `-delete`: 删除条目
> - `-exportcert`: 导出证书
> - `-genkeypair`: 生成密钥对
> - `-genseckey`: 生成密钥
> - `-gencert`: 从证书请求生成证书
> - `-importcert`:导入证书或证书链
> - `-importpass`: 导入密码
> - `-importkeystore`: 从另一个keystore(密钥库)导入一个或所有条目
> - `-keypasswd`: 更改条目的密钥密码
> - `-list`: 列出keystore(密钥库)中的条目
> - `-printcert`: 打印证书的内容
> - `-printcertreq`: 打印证书请求的内容
> - `-printcrl`: 打印证书吊销列表 (CRL) 文件的内容
> - `-storepasswd`: 更改keystore(密钥库)的存储密码
> - `-showinfo`: 显示安全相关信息
> - `-version`: 打印程序版本

有关这些命令及其选项的说明，请参阅命令和选项。

## 描述

keytool 命令是一个密钥和证书管理实用程序。它使用户能够通过使用数字签名管理自己的公钥/私钥对和相关证书，以用于自我认证（用户向其他用户和服务认证自己）或数据完整性和认证服务。 keytool 命令还使用户能够缓存其通信对等方的公钥（以证书的形式）。

证书是来自一个实体（个人、公司等）的数字签名声明，它表明某个其他实体的公钥（和一些其他信息）具有特定的价值。当数据被数字签名时，可以验证签名以检查数据的完整性和真实性。完整性意味着数据没有被修改或篡改，真实性意味着数据来自声称创建并签署它的个人。

keytool 命令还使用户能够管理对称加密和解密（数据加密标准）中使用的密钥和密码。它还可以显示其他与安全相关的信息。

keytool 命令将密钥和证书存储在keystore(密钥库)中。

keytool 命令使用 jdk.certpath.disabledAlgorithms 和 jdk.security.legacyAlgorithms 安全属性来确定哪些算法被视为安全风险。当禁用或使用旧算法时，它会发出警告。 jdk.certpath.disabledAlgorithms 和 jdk.security.legacyAlgorithms 安全属性在 java.security 文件（位于 JDK 的 $JAVA_HOME/conf/security 目录中）中定义。

## 命令和选项说明

以下注释适用于命令和选项中的描述：

- 所有命令和选项名称前面都有一个连字符 (-)。

- 只能提供一个命令。

- 可以按任何顺序提供每个命令的选项。

- 选项有两种，一种是单值，只能提供一次。如果多次提供单值选项，则使用最后一个的值。另一种是多值类型，可以多次提供，所有值都被使用。当前支持的唯一多值选项是用于生成 X.509v3 证书扩展的 -ext 选项。

- 所有非斜体或大括号 ({ }) 或方括号 ([ ]) 中的项目都必须按原样显示。

- 选项周围的大括号表示在命令行上未指定选项时使用默认值。大括号也用于 -v、-rfc 和 -J 选项，它们仅在出现在命令行上时才有意义。它们没有任何默认值。

- 选项周围的括号表示当命令行上未指定选项时提示用户输入值。对于 -keypass 选项，如果您没有在命令行中指定该选项，那么 keytool 命令首先会尝试使用密钥库密码来恢复私钥/秘密密钥。如果此尝试失败，则 keytool 命令会提示您输入私钥/密钥密码。

- 斜体项目（选项值）表示必须提供的实际值。例如，这里是 -printcert 命令的格式：

  > keytool -printcert {-file *cert_file*} {-v}
  >
  > 指定 -printcert 命令时，将 cert_file 替换为实际文件名，如下所示： 
  >
  > keytool -printcert -file VScert.cer

- 选项值包含空白（空间）时，必须将选项值封闭在引号中。

## 命令和选项

keytool 命令及其选项可以按它们执行的任务进行分组。

用于创建或添加数据到密钥库的命令:

- `-gencert`
- `-genkeypair`
- `-genseckey`
- `-importcert`
- `-importpass`

从另一个密钥库导入内容的命令:

- `-importkeystore`

生成证书请求的命令:

- `-certreq`

导出数据的命令:

- `-exportcert`

显示数据的命令:

- `-list`
- `-printcert`
- `-printcertreq`
- `-printcrl`

管理密钥库的命令:

- `-storepasswd`
- `-keypasswd`
- `-delete`
- `-changealias`

显示安全相关信息的命令:

- `-showinfo`

显示程序版本的命令:

- `-version`

## 用于创建或添加数据到密钥库的命令

`-gencert`

以下是 `-gencert` 命令的可用选项:

- {`-rfc`}: 以 RFC（请求评论）样式输出

- {`-infile` *infile*}: 输入文件名

- {`-outfile` *outfile*}: 输出文件名

- {`-alias` *alias*}: 要处理的条目的别名

- {`-sigalg` *sigalg*}: 签名算法名称

- {`-dname` *dname*}:专有名称

- {`-startdate` *startdate*}: 证书有效期开始日期和时间

- {`-ext` *ext*}*: X.509 扩展

- {`-validity` *days*}: 有效天数

- [`-keypass` *arg ] : 密钥密码

- {`-keystore` *keystore*}: 密钥库名称

- [`-storepass` *arg*] : 密钥库密码

- {`-storetype` *type*}: 密钥库类型

- {`-providername` *name*}: 提供者名称

- {`-addprovider` *name* [`-providerarg` *arg*]}: 按名称添加安全提供程序（例如 SunPKCS11），并带有可选的配置参数。 安全提供者的值是在模块中定义的安全提供者的名称。

  例如，

  > `keytool -addprovider SunPKCS11 -providerarg some.cfg ...`

  **Note:**

  出于兼容性原因，即使现在在模块中定义了 SunPKCS11 提供程序，仍然可以使用 `-providerclass sun.security.pkcs11.SunPKCS11` 加载它。 这是 JDK 中唯一需要配置的模块，因此与 `-providerclass` 选项一起使用最广泛。 对于位于类路径上并通过反射加载的遗留安全提供程序，仍应使用 `-providerclass`。

- {`-providerclass` *class* [`-providerarg` *arg*]}: 通过带有可选配置参数的完全限定类名添加安全提供程序。

  例如，如果 `MyProvider` 是通过反射加载的旧提供程序，

  > `keytool -providerclass com.example.MyProvider ...`

- {`-providerpath` *list*}: 提供者类路径

- {`-v`}: 详细输出

- {`-protected`}: 通过受保护机制提供的密码