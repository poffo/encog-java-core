/*
 * Encog(tm) Core v3.4 - Java Version
 * http://www.heatonresearch.com/encog/
 * https://github.com/encog/encog-java-core
 
 * Copyright 2008-2016 Heaton Research, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *   
 * For more information on Heaton Research copyrights, licenses 
 * and trademarks visit:
 * http://www.heatonresearch.com/copyright
 */
package org.encog.util.data;

import org.encog.mathutil.EncogFunction;
import org.encog.mathutil.randomize.generate.GenerateRandom;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataSet;

/**
 * Utility class used to create training data from a function.
 * @author jheaton
 *
 */
public class GenerationUtil {
	public static MLDataSet generateSingleDataRange(EncogFunction task, double start, double stop, double step) {
		BasicMLDataSet result = new BasicMLDataSet();
		double[] current = new double[task.size()];
		
		while(current[0]<=stop) {
			MLData input = new BasicMLData(current);
			MLData ideal = new BasicMLData(1);
			ideal.setData(0, task.fn(current));
			result.add(input,ideal);
			current[0]+=step;
		}
		
		return result;
	}

	public static MLDataSet generateRandom(GenerateRandom rnd, EncogFunction task, int size, double low, double high) {
		BasicMLDataSet result = new BasicMLDataSet();


		for(int i=0;i<size;i++) {
            double[] current = new double[task.size()];
            for(int j=0;j<current.length;j++) {
                current[j] = rnd.nextDouble(low,high);
            }

			MLData input = new BasicMLData(current);
			MLData ideal = new BasicMLData(1);
			ideal.setData(0, task.fn(current));
			result.add(input,ideal);
		}

		return result;
	}
}
