package ru.gb.lesson8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

public class QuitFragment extends Fragment implements PopupMenu.OnMenuItemClickListener {

    private TextView quitText;
    private PopupMenu popupMenu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        quitText = view.findViewById(R.id.quit_fragment_text);

        popupMenu = new PopupMenu(requireActivity(), quitText);
        popupMenu.inflate(R.menu.main);

        popupMenu.setOnMenuItemClickListener(this);

        quitText.setOnClickListener(view1 -> popupMenu.show());

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.main_delete:
                return toast("Delete");
            case R.id.main_new:
                return toast("New");
            case R.id.main_quit:
                return toast("Quit");
        }
        return false;
    }

    public boolean toast(String text)
    {
        Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show();
        return true;
    }
}
