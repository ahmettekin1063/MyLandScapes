package com.ahmettekin.mylandscapes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_satir_manzara.view.*

class ManzaraAdapter(val manzaraList: ArrayList<Manzara>) :
    RecyclerView.Adapter<ManzaraAdapter.ManzaraViewHolder>() {

    inner class ManzaraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tekSatirManzara = itemView

        val manzaraBaslik = tekSatirManzara.tvManzaraBaslik
        val manzaraAciklama = tekSatirManzara.tvManzaraAciklama
        val manzaraResim = tekSatirManzara.imgManzara
        val silmeResmi = tekSatirManzara.imgSil
        val kopyalamaResmi = tekSatirManzara.imgKopyala


        fun setData(oAnOlusturulanManzara: Manzara, position: Int) {
            manzaraBaslik.text = oAnOlusturulanManzara.baslik
            manzaraAciklama.text = oAnOlusturulanManzara.aciklama
            manzaraResim.setImageResource(oAnOlusturulanManzara.resim)

            silmeResmi.setOnClickListener {
                manzaraList.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, manzaraList.size)
            }
            kopyalamaResmi.setOnClickListener {
                manzaraList.add(position, oAnOlusturulanManzara)
                notifyItemInserted(position)
                notifyItemRangeChanged(position, manzaraList.size)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManzaraViewHolder {
        return ManzaraViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tek_satir_manzara, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ManzaraViewHolder, position: Int) {

        val oAnOlusturulanManzara = manzaraList[position]
        holder.setData(oAnOlusturulanManzara, position)

        /* holder.manzaraBaslik.text = manzaraList[position].baslik
         holder.manzaraAciklama.text = manzaraList[position].aciklama
         holder.manzaraResim.setImageResource(manzaraList[position].resim)*/
    }

    override fun getItemCount(): Int {
        return manzaraList.size
    }

}