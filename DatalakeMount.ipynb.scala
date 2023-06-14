// Databricks notebook source
val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "4ac22c91-3962-44b1-8254-80a5342ae4a3",
  "fs.azure.account.oauth2.client.secret" -> "Hu8Q~HWeSHiAOv9okAKzGBqvG9iUtHYrNjrYaO1",
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/dfa2628e-6a57-47dc-9724-5e51d1d72008/oauth2/token");

// COMMAND ----------

// Optionally, you can add <directory-name> to the source URI of your mount point.
dbutils.fs.mount(
  source = "abfss://raw@sanjuaccount.dfs.core.windows.net/",
  mountPoint = "/mnt/eclasessbatch5",
  extraConfigs = configs)

// COMMAND ----------

// MAGIC %python
// MAGIC 
// MAGIC df=spark.read.parquet("/mnt/eclasessbatch5/userdata1.parquet")

// COMMAND ----------

// MAGIC %python
// MAGIC display(df)

// COMMAND ----------

dbutils.fs.unmount("/mnt/eclasessbatch5")
