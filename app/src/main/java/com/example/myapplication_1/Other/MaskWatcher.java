package com.example.myapplication_1.Other;

import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.Editable;

public class MaskWatcher implements TextWatcher {
    private boolean isRunning = false;
    private boolean isDeleting = false;
    private String mask;

    private MaskWatcher(String mask) {
        this.mask = mask;
    }

    public static MaskWatcher buildRusTelMask() {
        return new MaskWatcher("+#-###-###-##-##");
    }

    public MaskWatcher editMask(String newMask) {
        this.mask = newMask;
        return this;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        isDeleting = count > after;
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable editable) {

        int editableLength = editable.length();
        if(isDeleting && editableLength-1 >= 0 && mask.charAt(editableLength-1) != '#') {
            editable.delete(editableLength-1, editableLength);
        }
        if (isRunning || isDeleting) {
            return;
        }
        isRunning = true;

        if (editableLength < mask.length()) {
            if (mask.charAt(editableLength) != '#') {
                editable.append(mask.charAt(editableLength));
            } else if (mask.charAt(editableLength-1) != '#') {
                editable.insert(editableLength-1, mask, editableLength-1, editableLength);
            }
        }
        isRunning = false;
    }

    public static String normalText(String txt) {
        String[] arr = txt.split("-");
        return TextUtils.join("", arr);
    }
}