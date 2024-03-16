import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.greendzineassignment.DataClass
import com.example.greendzineassignment.DataForProgress
import com.example.greendzineassignment.DataForProgressList
import com.example.greendzineassignment.R

class HomeAdapter(private val dataList: List<DataForProgress>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_progress, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.dayTextView.text = item.day
        holder.percentTextView.text = item.percentage
        holder.progressTextView.progress = item.progress
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayTextView: TextView = view.findViewById(R.id.day)
        val percentTextView: TextView = view.findViewById(R.id.percent)
        val progressTextView: ProgressBar = view.findViewById(R.id.progress)
    }
}
