#CommuniCase用spモードメール対応パッチ
CommuniCaseでspモードメールを使えるようにするパッチと
spモードメールをプッシュ受信するために必要なアプリです。

#パッチのあて方
$ apktool d com.nttdocomo.communicase.carriermail-1.apk
$ patch -p0 < spmode-support.patch
$ apktool b com.nttdocomo.communicase.carriermail-1 communicase_spmode-support.apk
$ jarsigner -keystore hogehoge.key communicase_spmode-support.apk hogehoge

#パッチの現状の問題点
wifiパスワードを設定しようとすると落ちます。
したがって、wifi経由でメールを送受信することは出来ません。

#プッシュ通知を受け取るためのアプリ
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

#SPPushSwitcher
プッシュ通知先をspモードメールとCommuniCaseのどちらにするかを切り替えるアプリです。
CommuniCaseアプリ内の設定からは通知先の変更はできません。
/system/app/に配置してください。
GalaxyNexusを使用している場合、SPModePushやSPModePushNotifier、MiniDcmWapPushHelperは削除してください。
インストール後、アプリを起動して通知先を選択してください。

#SPModeMailDummy
使用するにはspモードメールアプリをアンインストールする必要があります。
通常のアプリとしてインストールする場合、インストール後一度アプリを起動させてください。
/system/app/に配置する場合、配置後にアプリを起動させる必要はありません。
