#CommuniCase用spモードメール対応パッチ
CommuniCaseでspモードメールを使えるようにするパッチと  
spモードメールをプッシュ受信するために必要なアプリです。  
CommuniCase バージョン1.0.0に対応しています。

##更新情報
wifi経由での送信に対応しました。(2012/4/24)  
本来wifi接続用パスワードは別のアプリ(com.nttdocomo.android.accountauthenticator)  
が管理しているのですが、spモードメール非対応端末にはこのアプリが存在しません。  
そのため、このアプリを用いずにwifi接続用パスワードを管理するために  
3つのクラスを追加しました。  
パッチにはこれらのクラスが含まれているのですが  
処理内容が非常にわかりにくいと思います。  
そのため、元のjavaファイルをinjected_classesにて公開しておきました。  
パスワードを扱うデリケートな部分なので  
処理内容を確認しておくことをオススメします。

##動作確認端末
Galaxy Nexus
Galaxy S2
Xperia ray

##パッチのあて方
$ apktool d com.nttdocomo.communicase.carriermail-1.apk  
$ patch -p0 < spmode-support.patch  
$ apktool b com.nttdocomo.communicase.carriermail-1 communicase_spmode-support.apk  
$ jarsigner -keystore hogehoge.key communicase_spmode-support.apk hogehoge  

##プッシュ通知を受け取るためのアプリ
SPPushSwitcherとSPModeMailDummyの2つのアプリを提供しています。  
プッシュ通知を受け取るにはこのアプリのうちどちらかをインストールする必要があります。  
使用している端末により使用できるアプリが異なります。  
* WAPPushManagerが/system/app/に存在するrootedなICS端末  
 SPPushSwitcherを使用してください
* spモードメールアプリが通常のアプリとしてインストールされている端末の場合(/system/app/に配置されていない場合)  
 SPModeMailDummyを使用してください
* spモードメールアプリが/system/app/にインストールされているが、root権限を取得可能な場合  
 SPModeMailDummyを使用してください
* それ以外の場合  
 どちらのアプリも使用することは出来ません

##SPPushSwitcher
プッシュ通知先をspモードメールとCommuniCaseのどちらにするかを切り替えるアプリです。  
CommuniCaseアプリ内の設定からは通知先の変更はできません。  
/system/app/に配置してください。  
GalaxyNexusを使用している場合、SPModePushやSPModePushNotifier、MiniDcmWapPushHelperは削除してください。  
インストール後、アプリを起動して通知先を選択してください。  

##SPModeMailDummy
使用するにはspモードメールアプリをアンインストールする必要があります。  
通常のアプリとしてインストールしてください。  
インストール後は特に操作する必要はありません。
