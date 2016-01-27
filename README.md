# spring-mvc-singleton-vs-prototype

Spring Framework のスコープ (singleton / prototype) を Spring MVC で視覚的に確認

## Requirement
- JDK 8
- IntelliJ IDEA 15.x (ビルドに使用する場合)

## Usage
1. ソースをダウンロード or チェックアウト
2. ソースをビルドして実行 (いずれか)

  - CUI で gradlew / gradlew.bat を実行
  ```
SourceDirectory> gradlew.bat bootRun
```

  - IntelliJ IDEA で gradle refresh → bootRun

3. ブラウザで <http://localhost:8080> にアクセス

  F5 を押してハッシュコードが変わらないものが、実際にシングルトン  
  左フレーム : singleton スコープのコントローラクラス  
  右フレーム : prototype スコープのコントローラクラス

  | 名称              | 説明                                             |
  | ----------------- | ------------------------------------------------ |
  | controller        | コントローラ                                     |
  | singleton_member  | singleton スコープクラスのメンバ                 |
  | prototype_member  | prototype スコープクラスのメンバ                 |
  | singleton_created | singleton スコープクラスのローカル変数 [*1](#*1) |
  | prototype_created | prototype スコープクラスのローカル変数 [*1](#*1) |

  <a name="*1"> *1 ローカル変数は [createAutowiredObject](http://stackoverflow.com/a/2383312) で生成
