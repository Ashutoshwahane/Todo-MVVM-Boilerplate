package xyz.cybernerd404.todo_mvvm_boilerplate.model

data class Todo(
    val `$clusterTime`: ClusterTime,
    val deletedCount: Int,
    val electionId: String,
    val n: Int,
    val ok: Int,
    val opTime: OpTime,
    val operationTime: String
)