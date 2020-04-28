package com.example.fadfadly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

public class Filtering extends AppCompatActivity {
    private Classifier mClassifier = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtering);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radios);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override


            public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch(checkedId)
                {
                    case R.id.sel:
                        Self5.list.add(7,"نفسك");
                        break;
                    case R.id.second:
                        Self5.list.add(7,"عائليا");
                        break;
                    case R.id.third:
                        Self5.list.add(7,"الاصدقاء");
                        break;
                    case R.id.fourth:
                        Self5.list.add(7,"عاطفيا");
                        break;
                    case R.id.fifth:
                        Self5.list.add(7,"الدراسه او العمل");
                        break;
                    case R.id.six:
                        Self5.list.add(7,"الفقدان");
                        break;


                    case R.id.seven:

                        Self5.list.add(7,"الشعور العام");
                        break;
                }

                //Do something

                // public void onNext(View view) {
                for (int i = 0; i < General1.list.size(); i++) {
                    Log.i("Value of general element " + i, String.valueOf(General1.list.get(i)));

                }
                double m1 = General1.list.get(0);
                double m2 = General1.list.get(1);
                double m3 = General1.list.get(2);
                double m4 = General1.list.get(3);
                double m5 = General1.list.get(4);
                double m6 = General1.list.get(5);
                double m7 = General1.list.get(6);
                double m8 = General1.list.get(7);
                double m9 = General1.list.get(8);
                double m10 = General1.list.get(9);
                double m11 = General1.list.get(10);

                Random mRandom = new Random();
                Sample[] mSamples = new Sample[]{
                        new Sample(new double[]{m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11}), // should be in the setosa domain

                };
                StringBuilder sb = new StringBuilder("Samples:\n");
                for (Sample s : mSamples) {
                    sb.append(s.toString() + "\n");
                }
                AssetManager assetManager = getAssets();
                try {
                    mClassifier = (Classifier) weka.core.SerializationHelper.read(assetManager.open("generall.model"));

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    // Weka "catch'em all!"
                    e.printStackTrace();
                }
                Log.i("model general load", "Model general Loaded");
                if (mClassifier == null) {
                    Log.i("model not load", "Model not Loaded");
                    return;
                }
                final Attribute attributeSepalLength = new Attribute("gen1");
                final Attribute attributeSepalWidth = new Attribute("gen2");
                final Attribute attributePetalLength = new Attribute("gen3");
                final Attribute attributePetalWidth = new Attribute("gen4");
                final Attribute attributePetalWidth2 = new Attribute("gen5");
                final Attribute attributePetalWidth3 = new Attribute("gen6");
                final Attribute attributePetalWidth4 = new Attribute("gen7");
                final Attribute attributePetalWidth5 = new Attribute("gen8");
                final Attribute attributePetalWidth6 = new Attribute("gen9");
                final Attribute attributePetalWidth7 = new Attribute("gen10");
                final Attribute attributePetalWidth8 = new Attribute("gen11");


                final List<String> classes = new ArrayList<String>() {
                    {
                        add("bad"); // cls nr 1
                        add("good"); // cls nr 2
                        add("excellent"); // cls nr 3
                    }
                };
                ArrayList<Attribute> attributeList = new ArrayList<Attribute>(2) {
                    {
                        add(attributeSepalLength);
                        add(attributeSepalWidth);
                        add(attributePetalLength);
                        add(attributePetalWidth);
                        add(attributePetalWidth2);
                        add(attributePetalWidth3);
                        add(attributePetalWidth4);
                        add(attributePetalWidth5);
                        add(attributePetalWidth6);
                        add(attributePetalWidth7);
                        add(attributePetalWidth8);


                        Attribute attributeClass = new Attribute("target", classes);
                        add(attributeClass);
                    }
                };

                Instances dataUnpredicted = new Instances("TestInstances",
                        attributeList, 1);
                // last feature is target variable
                dataUnpredicted.setClassIndex(dataUnpredicted.numAttributes() - 1);
                // create new instance: this one should fall into the setosa domain
                final Sample s = mSamples[mRandom.nextInt(mSamples.length)];
                DenseInstance newInstance = new DenseInstance(dataUnpredicted.numAttributes()) {
                    {
                        setValue(attributeSepalLength, s.features[0]);
                        setValue(attributeSepalWidth, s.features[1]);
                        setValue(attributePetalLength, s.features[2]);
                        setValue(attributePetalWidth, s.features[3]);
                        setValue(attributePetalWidth2, s.features[4]);
                        setValue(attributePetalWidth3, s.features[5]);
                        setValue(attributePetalWidth4, s.features[6]);
                        setValue(attributePetalWidth5, s.features[7]);
                        setValue(attributePetalWidth6, s.features[8]);
                        setValue(attributePetalWidth7, s.features[9]);
                        setValue(attributePetalWidth8, s.features[10]);

                    }
                };
                newInstance.setDataset(dataUnpredicted);


                try {
                    double result = mClassifier.classifyInstance(newInstance);
                    String className = classes.get(new Double(result).intValue());
                    String msg = ", general predicted: " + className;
                    Log.i("WEKA_TEST", msg);
                    Self5.list.add(6,className+"general");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            /*    Intent intent=new Intent(Filtering.this,Filtering2.class);

                startActivity(intent);*/

            }
        });
    }

    public void onfil(View view) {

        Intent intent=new Intent(this,Filtering2.class);

        startActivity(intent);

    }


    public class Sample {

        public double [] features;

        public Sample(double[] _features) {

            //  this.label = _label;
            this.features = _features;
        }

        @Override
        public String toString() {
            return

                    ", feat: " + Arrays.toString(features);
        }
    }

}

