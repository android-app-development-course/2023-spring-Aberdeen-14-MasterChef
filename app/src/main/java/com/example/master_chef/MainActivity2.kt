package com.example.master_chef

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var noResultsTextView: TextView
    private lateinit var recipeListView: ListView
    private lateinit var recipeAdapter: ArrayAdapter<String>

    private val recipeMap: MutableMap<String, String> = mutableMapOf(
        "番茄炒蛋" to "制作方法：\n1.倒入开水浸泡2分钟，让番茄在热水里翻滚一会,这样可以轻松去掉番茄的外皮。\n2.把番茄切成细丁。\n3.热锅冷油后放入番茄丁中小火边炒边用勺子碾压。\n4.当番茄汁变得浓稠时加入一勺白糖和适量盐调味，出锅备用。\n5.鸡蛋打入碗里，加入适量盐，打散后加一勺水继续打散。 \n6.加入切好的香葱继续打散鸡蛋。 \n7.热锅到锅子冒一点烟后加入食用油，晃动一下锅子，让锅四周都有沾到油。 \n8.下蛋液，轻轻转动锅子让蛋液流向四周，马上小火，凝结后弄碎鸡蛋出锅备用。 \n9.小番茄切块。 \n10.热锅冷油加入生姜丝煸炒出香味。 \n11.放入番茄块，大火翻炒,马上淋上一点点料酒，大火再翻炒几下。 \n12.慢慢加入上面做好的番茄酱，不断翻炒。 \n13.加入炒好的鸡蛋撒上香葱就可以出锅了。",
        "宫保鸡丁" to "制作方法：\n1.鸡腿肉清洗干净，然后切成小丁，加入盐半勺、老抽2克、料酒半勺、胡椒粉1克搅拌均匀，再加入淀粉半勺，搅拌均匀腌制5分钟。\n2.小葱切成段，姜切粒，蒜切蒜末，干辣椒剪成段。\n3.取一个碗，在碗中放料酒1勺、白糖20克、醋15克、生抽5克、盐半勺、鸡精半勺、胡椒粉1克、淀粉3克搅拌均匀。调成料汁。\n4.锅中放入适量油，加入鸡丁炸至8成熟，盛出。\n5.锅里留底油，爆香干辣椒、花椒、姜蒜粒，放入鸡丁炒匀，倒入调好的料汁炒至浓稠，倒入花生米、葱段拌匀即可。\n小提示:\n鸡腿肉要提前腌制一下，让鸡肉更加入味，同时口感也更好。",
        "剁椒鱼头" to "制作方法：\n1.将鱼头洗净，从鱼唇正中剖开，在鱼头下面鱼肉较厚的部分斜划几刀。\n2.将料酒、胡椒粉、盐撒在鱼头上，抹匀，腌制约20分钟。\n3.将高度白酒倒入剁椒中，拌匀备用。\n4.在腌制好的鱼头表面淋上少许油，抹匀。\n5.将姜切片、葱切段，铺在碗底。\n6.再放上处理好的鱼头。\n7.然后将步骤3的剁椒铺在鱼头上。\n8.蒸锅内放入适量的水，烧开，然后摆入鱼头，盖盖，大火隔水足汽蒸约10分钟。\n9.将蒸好后的鱼头取出，倒去碗内多余的汤汁，撒上葱花，淋入蒸鱼豉油，然后将适量的油烧热，泼在上面即可。",
        "草莓奶昔" to "制作方法：\n1.将纯牛奶准备好，放置一旁备用。牛奶最好放入冰箱中冷藏，冷藏五六个小时左右即可。\n2.准备好一个空碗，在碗中加入适量更多纯净水，在纯净水中加入适量的食用盐，搅拌均匀即可。\n3.将准备好的草莓放置一旁，准备一盆水，加入少许盐，把草莓倒入水中浸泡10分钟。\n4.将草莓清洗干净之后沥干水分，吸干水分之后的草莓切成小块备用即可。\n5.将准备好切片的草莓贴在玻璃杯边上。\n6.将剩下的草莓放入榨汁机中，加入适量的牛奶榨成奶昔，放入冰箱中冷餐半个小时左右即可食用。",
        "杨枝甘露" to "制作方法：\n1.把1000L水煮沸，然后把100g西米放进去，一边煮一边搅拌，煮久了会有点浓稠，这时可以加一碗清水进去，继续煮，直至西米都变透明后，把西米捞出来，过冷水，放一边待用。\n2.把100g牛奶倒进锅里，再把100g糖倒进去。把糖煮溶，这里要注意了，如果牛奶煮沸后要马上关火。因为牛奶煮沸后继续煮会分离起花。所以可以煮到80度左右，关火，让糖慢慢溶化。\n3.把250g的芒果用料理机打成芒果泥，放一边待用。\n4.把剩下的150g芒果切成一小粒一小粒的，放一边待用。\n5.椰果也是，全部切成一小粒一小粒的。\n6.用一个大盆，把80g的椰浆，100g淡奶油，剩下的250g纯牛奶倒进大盆里，最后把上面准备好的西米，牛奶糖水，芒果泥，芒果粒，椰果粒都倒进盆里，搅拌均匀，杨枝甘露就成了。最好放冰箱冷藏1小时左右，更好吃。\n7.将西柚粒弄散放置于饮品上。"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)
        noResultsTextView = findViewById(R.id.noResultsTextView)
        recipeListView = findViewById(R.id.recipeListView)

        recipeAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
        recipeListView.adapter = recipeAdapter

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            searchRecipes(query)
        }
        recipeListView.setOnItemClickListener { _, _, position, _ ->
            val selectedRecipeName = recipeAdapter.getItem(position)
            if (selectedRecipeName != null) {
                openRecipeDetails(selectedRecipeName)
            }
        }

    }

    private fun openRecipeDetails(recipeName: String) {
        val method = recipeMap[recipeName]
        if (method != null) {
            val intent = Intent(this, RecipeDetailsActivity::class.java)
            intent.putExtra("recipeName", recipeName)
            intent.putExtra("method", method)

            // 设置页面切换动画
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out)
            startActivity(intent, options.toBundle())
        } else {
            Toast.makeText(this, "找不到该食材的制作方法", Toast.LENGTH_SHORT).show()
        }
    }


    private fun searchRecipes(query: String) {
        val results = recipeMap.keys.filter { it.contains(query, ignoreCase = true) }

        if (results.isEmpty()) {
            noResultsTextView.visibility = TextView.VISIBLE
            recipeListView.visibility = ListView.GONE
        } else {
            noResultsTextView.visibility = TextView.GONE
            recipeListView.visibility = ListView.VISIBLE
            recipeAdapter.clear()
            recipeAdapter.addAll(results)
            recipeAdapter.notifyDataSetChanged()
        }
    }
}
