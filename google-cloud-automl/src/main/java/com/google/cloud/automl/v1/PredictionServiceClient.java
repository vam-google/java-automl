/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.automl.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.automl.v1.stub.PredictionServiceStub;
import com.google.cloud.automl.v1.stub.PredictionServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: AutoML Prediction API.
 *
 * <p>On any input that is documented to expect a string parameter in snake_case or kebab-case,
 * either of those cases is accepted.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
 *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
 *   ExamplePayload payload = ExamplePayload.newBuilder().build();
 *   Map&lt;String, String&gt; params = new HashMap&lt;&gt;();
 *   PredictResponse response = predictionServiceClient.predict(name, payload, params);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the predictionServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of PredictionServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * PredictionServiceSettings predictionServiceSettings =
 *     PredictionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PredictionServiceClient predictionServiceClient =
 *     PredictionServiceClient.create(predictionServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * PredictionServiceSettings predictionServiceSettings =
 *     PredictionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PredictionServiceClient predictionServiceClient =
 *     PredictionServiceClient.create(predictionServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class PredictionServiceClient implements BackgroundResource {
  private final PredictionServiceSettings settings;
  private final PredictionServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of PredictionServiceClient with default settings. */
  public static final PredictionServiceClient create() throws IOException {
    return create(PredictionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PredictionServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PredictionServiceClient create(PredictionServiceSettings settings)
      throws IOException {
    return new PredictionServiceClient(settings);
  }

  /**
   * Constructs an instance of PredictionServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use PredictionServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final PredictionServiceClient create(PredictionServiceStub stub) {
    return new PredictionServiceClient(stub);
  }

  /**
   * Constructs an instance of PredictionServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PredictionServiceClient(PredictionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PredictionServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected PredictionServiceClient(PredictionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final PredictionServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PredictionServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform an online prediction. The prediction result is directly returned in the response.
   * Available for following ML scenarios, and their expected request payloads:
   *
   * <p>&lt;table&gt; &lt;tr&gt; &lt;td&gt;AutoML Vision Classification&lt;/td&gt; &lt;td&gt;An
   * image in .JPEG, .GIF or .PNG format, image_bytes up to 30MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
   * &lt;td&gt;AutoML Vision Object Detection&lt;/td&gt; &lt;td&gt;An image in .JPEG, .GIF or .PNG
   * format, image_bytes up to 30MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;AutoML Natural
   * Language Classification&lt;/td&gt; &lt;td&gt;A TextSnippet up to 60,000 characters, UTF-8
   * encoded or a document in .PDF, .TIF or .TIFF format with size upto 2MB.&lt;/td&gt; &lt;/tr&gt;
   * &lt;tr&gt; &lt;td&gt;AutoML Natural Language Entity Extraction&lt;/td&gt; &lt;td&gt;A
   * TextSnippet up to 10,000 characters, UTF-8 NFC encoded or a document in .PDF, .TIF or .TIFF
   * format with size upto 20MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;AutoML Natural Language
   * Sentiment Analysis&lt;/td&gt; &lt;td&gt;A TextSnippet up to 60,000 characters, UTF-8 encoded or
   * a document in .PDF, .TIF or .TIFF format with size upto 2MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
   * &lt;td&gt;AutoML Translation&lt;/td&gt; &lt;td&gt;A TextSnippet up to 25,000 characters, UTF-8
   * encoded.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;AutoML Tables&lt;/td&gt; &lt;td&gt;A row
   * with column values matching the columns of the model, up to 5MB. Not available for FORECASTING
   * `prediction_type`. &lt;/td&gt; &lt;/tr&gt; &lt;/table&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   ExamplePayload payload = ExamplePayload.newBuilder().build();
   *   Map&lt;String, String&gt; params = new HashMap&lt;&gt;();
   *   PredictResponse response = predictionServiceClient.predict(name, payload, params);
   * }
   * </code></pre>
   *
   * @param name Required. Name of the model requested to serve the prediction.
   * @param payload Required. Payload to perform a prediction on. The payload must match the problem
   *     type that the model was trained to solve.
   * @param params Additional domain-specific parameters, any string must be up to 25000 characters
   *     long.
   *     <p>&lt;h4&gt;AutoML Vision Classification&lt;/h4&gt;
   *     <p>`score_threshold` : (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for an image, it will only produce results that have at least this confidence score. The
   *     default is 0.5.
   *     <p>&lt;h4&gt;AutoML Vision Object Detection&lt;/h4&gt;
   *     <p>`score_threshold` : (float) When Model detects objects on the image, it will only
   *     produce bounding boxes which have at least this confidence score. Value in 0 to 1 range,
   *     default is 0.5.
   *     <p>`max_bounding_box_count` : (int64) The maximum number of bounding boxes returned. The
   *     default is 100. The number of returned bounding boxes might be limited by the server.
   *     <p>&lt;h4&gt;AutoML Tables&lt;/h4&gt;
   *     <p>`feature_importance` : (boolean) Whether
   *     <p>[feature_importance][google.cloud.automl.v1.TablesModelColumnInfo.feature_importance] is
   *     populated in the returned list of
   *     [TablesAnnotation][google.cloud.automl.v1.TablesAnnotation] objects. The default is false.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictResponse predict(
      ModelName name, ExamplePayload payload, Map<String, String> params) {
    PredictRequest request =
        PredictRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPayload(payload)
            .putAllParams(params)
            .build();
    return predict(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform an online prediction. The prediction result is directly returned in the response.
   * Available for following ML scenarios, and their expected request payloads:
   *
   * <p>&lt;table&gt; &lt;tr&gt; &lt;td&gt;AutoML Vision Classification&lt;/td&gt; &lt;td&gt;An
   * image in .JPEG, .GIF or .PNG format, image_bytes up to 30MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
   * &lt;td&gt;AutoML Vision Object Detection&lt;/td&gt; &lt;td&gt;An image in .JPEG, .GIF or .PNG
   * format, image_bytes up to 30MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;AutoML Natural
   * Language Classification&lt;/td&gt; &lt;td&gt;A TextSnippet up to 60,000 characters, UTF-8
   * encoded or a document in .PDF, .TIF or .TIFF format with size upto 2MB.&lt;/td&gt; &lt;/tr&gt;
   * &lt;tr&gt; &lt;td&gt;AutoML Natural Language Entity Extraction&lt;/td&gt; &lt;td&gt;A
   * TextSnippet up to 10,000 characters, UTF-8 NFC encoded or a document in .PDF, .TIF or .TIFF
   * format with size upto 20MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;AutoML Natural Language
   * Sentiment Analysis&lt;/td&gt; &lt;td&gt;A TextSnippet up to 60,000 characters, UTF-8 encoded or
   * a document in .PDF, .TIF or .TIFF format with size upto 2MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
   * &lt;td&gt;AutoML Translation&lt;/td&gt; &lt;td&gt;A TextSnippet up to 25,000 characters, UTF-8
   * encoded.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;AutoML Tables&lt;/td&gt; &lt;td&gt;A row
   * with column values matching the columns of the model, up to 5MB. Not available for FORECASTING
   * `prediction_type`. &lt;/td&gt; &lt;/tr&gt; &lt;/table&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   ExamplePayload payload = ExamplePayload.newBuilder().build();
   *   Map&lt;String, String&gt; params = new HashMap&lt;&gt;();
   *   PredictResponse response = predictionServiceClient.predict(name.toString(), payload, params);
   * }
   * </code></pre>
   *
   * @param name Required. Name of the model requested to serve the prediction.
   * @param payload Required. Payload to perform a prediction on. The payload must match the problem
   *     type that the model was trained to solve.
   * @param params Additional domain-specific parameters, any string must be up to 25000 characters
   *     long.
   *     <p>&lt;h4&gt;AutoML Vision Classification&lt;/h4&gt;
   *     <p>`score_threshold` : (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for an image, it will only produce results that have at least this confidence score. The
   *     default is 0.5.
   *     <p>&lt;h4&gt;AutoML Vision Object Detection&lt;/h4&gt;
   *     <p>`score_threshold` : (float) When Model detects objects on the image, it will only
   *     produce bounding boxes which have at least this confidence score. Value in 0 to 1 range,
   *     default is 0.5.
   *     <p>`max_bounding_box_count` : (int64) The maximum number of bounding boxes returned. The
   *     default is 100. The number of returned bounding boxes might be limited by the server.
   *     <p>&lt;h4&gt;AutoML Tables&lt;/h4&gt;
   *     <p>`feature_importance` : (boolean) Whether
   *     <p>[feature_importance][google.cloud.automl.v1.TablesModelColumnInfo.feature_importance] is
   *     populated in the returned list of
   *     [TablesAnnotation][google.cloud.automl.v1.TablesAnnotation] objects. The default is false.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictResponse predict(
      String name, ExamplePayload payload, Map<String, String> params) {
    PredictRequest request =
        PredictRequest.newBuilder().setName(name).setPayload(payload).putAllParams(params).build();
    return predict(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform an online prediction. The prediction result is directly returned in the response.
   * Available for following ML scenarios, and their expected request payloads:
   *
   * <p>&lt;table&gt; &lt;tr&gt; &lt;td&gt;AutoML Vision Classification&lt;/td&gt; &lt;td&gt;An
   * image in .JPEG, .GIF or .PNG format, image_bytes up to 30MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
   * &lt;td&gt;AutoML Vision Object Detection&lt;/td&gt; &lt;td&gt;An image in .JPEG, .GIF or .PNG
   * format, image_bytes up to 30MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;AutoML Natural
   * Language Classification&lt;/td&gt; &lt;td&gt;A TextSnippet up to 60,000 characters, UTF-8
   * encoded or a document in .PDF, .TIF or .TIFF format with size upto 2MB.&lt;/td&gt; &lt;/tr&gt;
   * &lt;tr&gt; &lt;td&gt;AutoML Natural Language Entity Extraction&lt;/td&gt; &lt;td&gt;A
   * TextSnippet up to 10,000 characters, UTF-8 NFC encoded or a document in .PDF, .TIF or .TIFF
   * format with size upto 20MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;AutoML Natural Language
   * Sentiment Analysis&lt;/td&gt; &lt;td&gt;A TextSnippet up to 60,000 characters, UTF-8 encoded or
   * a document in .PDF, .TIF or .TIFF format with size upto 2MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
   * &lt;td&gt;AutoML Translation&lt;/td&gt; &lt;td&gt;A TextSnippet up to 25,000 characters, UTF-8
   * encoded.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;AutoML Tables&lt;/td&gt; &lt;td&gt;A row
   * with column values matching the columns of the model, up to 5MB. Not available for FORECASTING
   * `prediction_type`. &lt;/td&gt; &lt;/tr&gt; &lt;/table&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   ExamplePayload payload = ExamplePayload.newBuilder().build();
   *   PredictRequest request = PredictRequest.newBuilder()
   *     .setName(name.toString())
   *     .setPayload(payload)
   *     .build();
   *   PredictResponse response = predictionServiceClient.predict(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictResponse predict(PredictRequest request) {
    return predictCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform an online prediction. The prediction result is directly returned in the response.
   * Available for following ML scenarios, and their expected request payloads:
   *
   * <p>&lt;table&gt; &lt;tr&gt; &lt;td&gt;AutoML Vision Classification&lt;/td&gt; &lt;td&gt;An
   * image in .JPEG, .GIF or .PNG format, image_bytes up to 30MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
   * &lt;td&gt;AutoML Vision Object Detection&lt;/td&gt; &lt;td&gt;An image in .JPEG, .GIF or .PNG
   * format, image_bytes up to 30MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;AutoML Natural
   * Language Classification&lt;/td&gt; &lt;td&gt;A TextSnippet up to 60,000 characters, UTF-8
   * encoded or a document in .PDF, .TIF or .TIFF format with size upto 2MB.&lt;/td&gt; &lt;/tr&gt;
   * &lt;tr&gt; &lt;td&gt;AutoML Natural Language Entity Extraction&lt;/td&gt; &lt;td&gt;A
   * TextSnippet up to 10,000 characters, UTF-8 NFC encoded or a document in .PDF, .TIF or .TIFF
   * format with size upto 20MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;AutoML Natural Language
   * Sentiment Analysis&lt;/td&gt; &lt;td&gt;A TextSnippet up to 60,000 characters, UTF-8 encoded or
   * a document in .PDF, .TIF or .TIFF format with size upto 2MB.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
   * &lt;td&gt;AutoML Translation&lt;/td&gt; &lt;td&gt;A TextSnippet up to 25,000 characters, UTF-8
   * encoded.&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;AutoML Tables&lt;/td&gt; &lt;td&gt;A row
   * with column values matching the columns of the model, up to 5MB. Not available for FORECASTING
   * `prediction_type`. &lt;/td&gt; &lt;/tr&gt; &lt;/table&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   ExamplePayload payload = ExamplePayload.newBuilder().build();
   *   PredictRequest request = PredictRequest.newBuilder()
   *     .setName(name.toString())
   *     .setPayload(payload)
   *     .build();
   *   ApiFuture&lt;PredictResponse&gt; future = predictionServiceClient.predictCallable().futureCall(request);
   *   // Do something
   *   PredictResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PredictRequest, PredictResponse> predictCallable() {
    return stub.predictCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform a batch prediction. Unlike the online
   * [Predict][google.cloud.automl.v1.PredictionService.Predict], batch prediction result won't be
   * immediately available in the response. Instead, a long running operation object is returned.
   * User can poll the operation result via
   * [GetOperation][google.longrunning.Operations.GetOperation] method. Once the operation is done,
   * [BatchPredictResult][google.cloud.automl.v1.BatchPredictResult] is returned in the
   * [response][google.longrunning.Operation.response] field. Available for following ML scenarios:
   *
   * <p>&#42; AutoML Vision Classification &#42; AutoML Vision Object Detection &#42; AutoML Video
   * Intelligence Classification &#42; AutoML Video Intelligence Object Tracking &#42; AutoML
   * Natural Language Classification &#42; AutoML Natural Language Entity Extraction &#42; AutoML
   * Natural Language Sentiment Analysis &#42; AutoML Tables
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   BatchPredictInputConfig inputConfig = BatchPredictInputConfig.newBuilder().build();
   *   BatchPredictOutputConfig outputConfig = BatchPredictOutputConfig.newBuilder().build();
   *   Map&lt;String, String&gt; params = new HashMap&lt;&gt;();
   *   BatchPredictResult response = predictionServiceClient.batchPredictAsync(name, inputConfig, outputConfig, params).get();
   * }
   * </code></pre>
   *
   * @param name Required. Name of the model requested to serve the batch prediction.
   * @param inputConfig Required. The input configuration for batch prediction.
   * @param outputConfig Required. The Configuration specifying where output predictions should be
   *     written.
   * @param params Additional domain-specific parameters for the predictions, any string must be up
   *     to 25000 characters long.
   *     <p>&lt;h4&gt;AutoML Natural Language Classification&lt;/h4&gt;
   *     <p>`score_threshold` : (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for a text snippet, it will only produce results that have at least this confidence score.
   *     The default is 0.5.
   *     <p>&lt;h4&gt;AutoML Vision Classification&lt;/h4&gt;
   *     <p>`score_threshold` : (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for an image, it will only produce results that have at least this confidence score. The
   *     default is 0.5.
   *     <p>&lt;h4&gt;AutoML Vision Object Detection&lt;/h4&gt;
   *     <p>`score_threshold` : (float) When Model detects objects on the image, it will only
   *     produce bounding boxes which have at least this confidence score. Value in 0 to 1 range,
   *     default is 0.5.
   *     <p>`max_bounding_box_count` : (int64) The maximum number of bounding boxes returned per
   *     image. The default is 100, the number of bounding boxes returned might be limited by the
   *     server. &lt;h4&gt;AutoML Video Intelligence Classification&lt;/h4&gt;
   *     <p>`score_threshold` : (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for a video, it will only produce results that have at least this confidence score. The
   *     default is 0.5.
   *     <p>`segment_classification` : (boolean) Set to true to request segment-level
   *     classification. AutoML Video Intelligence returns labels and their confidence scores for
   *     the entire segment of the video that user specified in the request configuration. The
   *     default is true.
   *     <p>`shot_classification` : (boolean) Set to true to request shot-level classification.
   *     AutoML Video Intelligence determines the boundaries for each camera shot in the entire
   *     segment of the video that user specified in the request configuration. AutoML Video
   *     Intelligence then returns labels and their confidence scores for each detected shot, along
   *     with the start and end time of the shot. The default is false.
   *     <p>WARNING: Model evaluation is not done for this classification type, the quality of it
   *     depends on training data, but there are no metrics provided to describe that quality.
   *     <p>`1s_interval_classification` : (boolean) Set to true to request classification for a
   *     video at one-second intervals. AutoML Video Intelligence returns labels and their
   *     confidence scores for each second of the entire segment of the video that user specified in
   *     the request configuration. The default is false.
   *     <p>WARNING: Model evaluation is not done for this classification type, the quality of it
   *     depends on training data, but there are no metrics provided to describe that quality.
   *     <p>&lt;h4&gt;AutoML Video Intelligence Object Tracking&lt;/h4&gt;
   *     <p>`score_threshold` : (float) When Model detects objects on video frames, it will only
   *     produce bounding boxes which have at least this confidence score. Value in 0 to 1 range,
   *     default is 0.5.
   *     <p>`max_bounding_box_count` : (int64) The maximum number of bounding boxes returned per
   *     image. The default is 100, the number of bounding boxes returned might be limited by the
   *     server.
   *     <p>`min_bounding_box_size` : (float) Only bounding boxes with shortest edge at least that
   *     long as a relative value of video frame size are returned. Value in 0 to 1 range. Default
   *     is 0.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<BatchPredictResult, OperationMetadata> batchPredictAsync(
      ModelName name,
      BatchPredictInputConfig inputConfig,
      BatchPredictOutputConfig outputConfig,
      Map<String, String> params) {
    BatchPredictRequest request =
        BatchPredictRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setInputConfig(inputConfig)
            .setOutputConfig(outputConfig)
            .putAllParams(params)
            .build();
    return batchPredictAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform a batch prediction. Unlike the online
   * [Predict][google.cloud.automl.v1.PredictionService.Predict], batch prediction result won't be
   * immediately available in the response. Instead, a long running operation object is returned.
   * User can poll the operation result via
   * [GetOperation][google.longrunning.Operations.GetOperation] method. Once the operation is done,
   * [BatchPredictResult][google.cloud.automl.v1.BatchPredictResult] is returned in the
   * [response][google.longrunning.Operation.response] field. Available for following ML scenarios:
   *
   * <p>&#42; AutoML Vision Classification &#42; AutoML Vision Object Detection &#42; AutoML Video
   * Intelligence Classification &#42; AutoML Video Intelligence Object Tracking &#42; AutoML
   * Natural Language Classification &#42; AutoML Natural Language Entity Extraction &#42; AutoML
   * Natural Language Sentiment Analysis &#42; AutoML Tables
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   BatchPredictInputConfig inputConfig = BatchPredictInputConfig.newBuilder().build();
   *   BatchPredictOutputConfig outputConfig = BatchPredictOutputConfig.newBuilder().build();
   *   Map&lt;String, String&gt; params = new HashMap&lt;&gt;();
   *   BatchPredictResult response = predictionServiceClient.batchPredictAsync(name.toString(), inputConfig, outputConfig, params).get();
   * }
   * </code></pre>
   *
   * @param name Required. Name of the model requested to serve the batch prediction.
   * @param inputConfig Required. The input configuration for batch prediction.
   * @param outputConfig Required. The Configuration specifying where output predictions should be
   *     written.
   * @param params Additional domain-specific parameters for the predictions, any string must be up
   *     to 25000 characters long.
   *     <p>&lt;h4&gt;AutoML Natural Language Classification&lt;/h4&gt;
   *     <p>`score_threshold` : (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for a text snippet, it will only produce results that have at least this confidence score.
   *     The default is 0.5.
   *     <p>&lt;h4&gt;AutoML Vision Classification&lt;/h4&gt;
   *     <p>`score_threshold` : (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for an image, it will only produce results that have at least this confidence score. The
   *     default is 0.5.
   *     <p>&lt;h4&gt;AutoML Vision Object Detection&lt;/h4&gt;
   *     <p>`score_threshold` : (float) When Model detects objects on the image, it will only
   *     produce bounding boxes which have at least this confidence score. Value in 0 to 1 range,
   *     default is 0.5.
   *     <p>`max_bounding_box_count` : (int64) The maximum number of bounding boxes returned per
   *     image. The default is 100, the number of bounding boxes returned might be limited by the
   *     server. &lt;h4&gt;AutoML Video Intelligence Classification&lt;/h4&gt;
   *     <p>`score_threshold` : (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for a video, it will only produce results that have at least this confidence score. The
   *     default is 0.5.
   *     <p>`segment_classification` : (boolean) Set to true to request segment-level
   *     classification. AutoML Video Intelligence returns labels and their confidence scores for
   *     the entire segment of the video that user specified in the request configuration. The
   *     default is true.
   *     <p>`shot_classification` : (boolean) Set to true to request shot-level classification.
   *     AutoML Video Intelligence determines the boundaries for each camera shot in the entire
   *     segment of the video that user specified in the request configuration. AutoML Video
   *     Intelligence then returns labels and their confidence scores for each detected shot, along
   *     with the start and end time of the shot. The default is false.
   *     <p>WARNING: Model evaluation is not done for this classification type, the quality of it
   *     depends on training data, but there are no metrics provided to describe that quality.
   *     <p>`1s_interval_classification` : (boolean) Set to true to request classification for a
   *     video at one-second intervals. AutoML Video Intelligence returns labels and their
   *     confidence scores for each second of the entire segment of the video that user specified in
   *     the request configuration. The default is false.
   *     <p>WARNING: Model evaluation is not done for this classification type, the quality of it
   *     depends on training data, but there are no metrics provided to describe that quality.
   *     <p>&lt;h4&gt;AutoML Video Intelligence Object Tracking&lt;/h4&gt;
   *     <p>`score_threshold` : (float) When Model detects objects on video frames, it will only
   *     produce bounding boxes which have at least this confidence score. Value in 0 to 1 range,
   *     default is 0.5.
   *     <p>`max_bounding_box_count` : (int64) The maximum number of bounding boxes returned per
   *     image. The default is 100, the number of bounding boxes returned might be limited by the
   *     server.
   *     <p>`min_bounding_box_size` : (float) Only bounding boxes with shortest edge at least that
   *     long as a relative value of video frame size are returned. Value in 0 to 1 range. Default
   *     is 0.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<BatchPredictResult, OperationMetadata> batchPredictAsync(
      String name,
      BatchPredictInputConfig inputConfig,
      BatchPredictOutputConfig outputConfig,
      Map<String, String> params) {
    BatchPredictRequest request =
        BatchPredictRequest.newBuilder()
            .setName(name)
            .setInputConfig(inputConfig)
            .setOutputConfig(outputConfig)
            .putAllParams(params)
            .build();
    return batchPredictAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform a batch prediction. Unlike the online
   * [Predict][google.cloud.automl.v1.PredictionService.Predict], batch prediction result won't be
   * immediately available in the response. Instead, a long running operation object is returned.
   * User can poll the operation result via
   * [GetOperation][google.longrunning.Operations.GetOperation] method. Once the operation is done,
   * [BatchPredictResult][google.cloud.automl.v1.BatchPredictResult] is returned in the
   * [response][google.longrunning.Operation.response] field. Available for following ML scenarios:
   *
   * <p>&#42; AutoML Vision Classification &#42; AutoML Vision Object Detection &#42; AutoML Video
   * Intelligence Classification &#42; AutoML Video Intelligence Object Tracking &#42; AutoML
   * Natural Language Classification &#42; AutoML Natural Language Entity Extraction &#42; AutoML
   * Natural Language Sentiment Analysis &#42; AutoML Tables
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   BatchPredictInputConfig inputConfig = BatchPredictInputConfig.newBuilder().build();
   *   BatchPredictOutputConfig outputConfig = BatchPredictOutputConfig.newBuilder().build();
   *   BatchPredictRequest request = BatchPredictRequest.newBuilder()
   *     .setName(name.toString())
   *     .setInputConfig(inputConfig)
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   BatchPredictResult response = predictionServiceClient.batchPredictAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<BatchPredictResult, OperationMetadata> batchPredictAsync(
      BatchPredictRequest request) {
    return batchPredictOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform a batch prediction. Unlike the online
   * [Predict][google.cloud.automl.v1.PredictionService.Predict], batch prediction result won't be
   * immediately available in the response. Instead, a long running operation object is returned.
   * User can poll the operation result via
   * [GetOperation][google.longrunning.Operations.GetOperation] method. Once the operation is done,
   * [BatchPredictResult][google.cloud.automl.v1.BatchPredictResult] is returned in the
   * [response][google.longrunning.Operation.response] field. Available for following ML scenarios:
   *
   * <p>&#42; AutoML Vision Classification &#42; AutoML Vision Object Detection &#42; AutoML Video
   * Intelligence Classification &#42; AutoML Video Intelligence Object Tracking &#42; AutoML
   * Natural Language Classification &#42; AutoML Natural Language Entity Extraction &#42; AutoML
   * Natural Language Sentiment Analysis &#42; AutoML Tables
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   BatchPredictInputConfig inputConfig = BatchPredictInputConfig.newBuilder().build();
   *   BatchPredictOutputConfig outputConfig = BatchPredictOutputConfig.newBuilder().build();
   *   BatchPredictRequest request = BatchPredictRequest.newBuilder()
   *     .setName(name.toString())
   *     .setInputConfig(inputConfig)
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   OperationFuture&lt;BatchPredictResult, OperationMetadata&gt; future = predictionServiceClient.batchPredictOperationCallable().futureCall(request);
   *   // Do something
   *   BatchPredictResult response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<BatchPredictRequest, BatchPredictResult, OperationMetadata>
      batchPredictOperationCallable() {
    return stub.batchPredictOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Perform a batch prediction. Unlike the online
   * [Predict][google.cloud.automl.v1.PredictionService.Predict], batch prediction result won't be
   * immediately available in the response. Instead, a long running operation object is returned.
   * User can poll the operation result via
   * [GetOperation][google.longrunning.Operations.GetOperation] method. Once the operation is done,
   * [BatchPredictResult][google.cloud.automl.v1.BatchPredictResult] is returned in the
   * [response][google.longrunning.Operation.response] field. Available for following ML scenarios:
   *
   * <p>&#42; AutoML Vision Classification &#42; AutoML Vision Object Detection &#42; AutoML Video
   * Intelligence Classification &#42; AutoML Video Intelligence Object Tracking &#42; AutoML
   * Natural Language Classification &#42; AutoML Natural Language Entity Extraction &#42; AutoML
   * Natural Language Sentiment Analysis &#42; AutoML Tables
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   BatchPredictInputConfig inputConfig = BatchPredictInputConfig.newBuilder().build();
   *   BatchPredictOutputConfig outputConfig = BatchPredictOutputConfig.newBuilder().build();
   *   BatchPredictRequest request = BatchPredictRequest.newBuilder()
   *     .setName(name.toString())
   *     .setInputConfig(inputConfig)
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = predictionServiceClient.batchPredictCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchPredictRequest, Operation> batchPredictCallable() {
    return stub.batchPredictCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
