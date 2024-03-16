import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.greendzineassignment.DataClass
import com.example.greendzineassignment.R

class EmployeeAdapter(private var dataList: List<DataClass>) :
    RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_view2, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFilteredList(list: List<DataClass>) {
        this.dataList = list
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.empIdTextView.text = item.emp_id.toString()
        holder.nameTextView.text = item.name
        holder.dobTextView.text = item.dob
        holder.roleTextView.text = item.role
        holder.corner_intTV.text = (position + 1).toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val empIdTextView: TextView = view.findViewById(R.id.emp_id)
        val nameTextView: TextView = view.findViewById(R.id.name)
        val dobTextView: TextView = view.findViewById(R.id.dob)
        val roleTextView: TextView = view.findViewById(R.id.role)
        val corner_intTV : TextView = view.findViewById(R.id.corner_int)
    }
}
