package com.project.site.base.exception;

import com.project.site.base.util.ListOrderedMap;
import com.project.site.base.util.StringUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component("baseRemoteExceptionRegistry")
public class BaseRemoteExceptionRegistry implements BaseRemoteExceptionConstants {
    public static final String BEAN_NAME = "baseRemoteExceptionRegistry";
    private static Map<Integer, RemoteException> typeToExceptionRegistry = new ListOrderedMap();

    public BaseRemoteExceptionRegistry() {
    }

    @PostConstruct
    protected void register() {
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, STATUS__BAD_REQUEST, "error400"));
        this.register(createTemplateWithBaseMessage(STATUS__UNAUTHORIZED, STATUS__UNAUTHORIZED, "error401"));
        this.register(createTemplateWithBaseMessage(STATUS__FORBIDDEN, STATUS__FORBIDDEN, "error403"));
        this.register(createTemplateWithBaseMessage(STATUS__NOT_FOUND, STATUS__NOT_FOUND, "error404"));
        this.register(createTemplateWithBaseMessage(STATUS__METHOD_NOT_ALLOWED, STATUS__METHOD_NOT_ALLOWED, "error405"));
        this.register(createTemplateWithBaseMessage(STATUS__TOO_MANY_REQUESTS, STATUS__TOO_MANY_REQUESTS, "error429"));
        this.register(createTemplateWithBaseMessage(STATUS__INTERNAL_SERVER_ERROR, STATUS__INTERNAL_SERVER_ERROR, "error500"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__INSERT_PROPERTY, "errorInsertProperty"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_MUST_BE_DECIMAL, "errorPropertyMustBeDecimal"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_MUST_BE_NON_NEGATIVE_DECIMAL, "errorPropertyMustBeNonNegativeDecimal"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_MUST_BE_DOUBLE, "errorPropertyMustBeDouble"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_MUST_BE_BETWEEN, "errorPropertyMustBeBetween"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_MUST_BE_GREATER_THAN, "errorPropertyMustBeGreaterThan"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_MUST_BE_GREATER_THAN_OR_EQUAL, "errorPropertyMustBeGreaterThanOrEqual"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_MUST_BE_LESS_THAN, "errorPropertyMustBeLessThan"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_MUST_BE_LESS_THAN_OR_EQUAL, "errorPropertyMustBeLessThanOrEqual"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_MUST_BE_EQUAL_TO, "errorPropertyMustBeEqualTo"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_LENGTH_MUST_BE_BETWEEN, "errorPropertyLengthMustBeBetween"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_LENGTH_MUST_BE_GREATER_THAN, "errorPropertyLengthMustBeGreaterThan"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_LENGTH_MUST_BE_GREATER_THAN_OR_EQUAL, "errorPropertyLengthMustBeGreaterThanOrEqual"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_LENGTH_MUST_BE_LESS_THAN, "errorPropertyLengthMustBeLessThan"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_LENGTH_MUST_BE_LESS_THAN_OR_EQUAL, "errorPropertyLengthMustBeLessThanOrEqual"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_LENGTH_MUST_BE_EQUAL_TO, "errorPropertyLengthMustBeEqualTo"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_STRUCTURE_IS_WRONG, "errorPropertyStructureIsWrong"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_IS_BIGGER_THAN_ALLOWED, "errorPropertyIsBiggerThanAllowed"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_IS_LESS_THAN_ALLOWED, "errorPropertyIsLessThanAllowed"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_IS_NOT_CORRECT, "errorPropertyIsNotCorrect"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTIES_MUST_BE_EQUAL, "errorPropertiesMustBeEqual"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTIES_MUST_NOT_BE_EQUAL, "errorPropertiesMustNotBeEqual"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_MUST_BE_UNIQUE, "errorPropertyMustBeUnique"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_MUST_STARTS_WITH, "errorPropertyMustStartsWith"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__SOME_INVALID_CHARACTERS_ENTERED, "errorSomeInvalidCharactersEntered"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__SELECT_AT_LEAST_ONE_ITEM, "errorSelectAtLeastOneItem"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__SELECT_JUST_ONE_ITEM, "errorSelectJustOneItem"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__PROPERTY_MUST_CONTAINS_ONLY_DIGITS, "errorPropertyMustContainsOnlyDigits"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__DATE_MUST_BE_BEFORE_TODAY, "errorDateMustBeBeforeToday"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__DATE_MUST_BE_BEFORE_OR_EQUAL_TODAY, "errorDateMustBeBeforeOrEqualToday"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__DATE_MUST_BE_AFTER_TODAY, "errorDateMustBeAfterToday"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__DATE_MUST_BE_AFTER_OR_EQUAL_TODAY, "errorDateMustBeAfterOrEqualToday"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__DATE_FORMAT_IS_INCORRECT, "errorDateFormatIsIncorrect"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__DATE_IS_OLDER_THAN_THRESHOLD, "errorDateIsOlderThanThreshold"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__IS_INVALID, "errorIsInvalid"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__SOME_PROPERTIES_ARE_REQUIRED, "errorSomePropertiesAreRequired"));
        this.register(createTemplateWithBaseMessage(STATUS__BAD_REQUEST, BASE__SOME_PROPERTIES_MUST_BE_UNIQUE, "errorSomePropertiesMustBeUnique"));
        this.register(createTemplateWithCoreMessage(STATUS__BAD_REQUEST, BASE__ENTITY_CANNOT_BE_DELETED_BECAUSE_OF_RELATION, "errorEntityCannotBeDeletedBecauseOfRelation"));
        this.register(createTemplateWithCoreMessage(STATUS__BAD_REQUEST, BASE__FOREIGN_KEY_DOES_NOT_EXIST, "errorForeignKeyDoesNotExist"));
        this.register(createTemplateWithCoreMessage(STATUS__BAD_REQUEST, BASE__LENGTH_EXCEEDED, "errorLengthExceeded"));
        this.register(createTemplateWithCoreMessage(STATUS__BAD_REQUEST, BASE__SOME_LENGTHS_EXCEEDED, "errorSomeLengthsExceeded"));
        this.register(createTemplateWithCoreMessage(STATUS__INTERNAL_SERVER_ERROR, BASE__INVALID_TYPE, "errorInvalidType"));
        this.register(createTemplateWithCoreMessage(STATUS__INTERNAL_SERVER_ERROR, BASE__INVALID_TYPE_OR_LENGTH, "errorInvalidTypeOrLength"));
        this.register(createTemplateWithCoreMessage(STATUS__BAD_REQUEST, BASE__TOO_LARGE_SINGLE_FILE, "errorTooLargeSingleFileWithSpecifiedName"));
        this.register(createTemplateWithCoreMessage(STATUS__BAD_REQUEST, BASE__INVALID_FORM_ENCODING, "errorInvalidFormEncoding"));
        this.register(createTemplateWithCoreMessage(STATUS__BAD_REQUEST, BASE__ANOTHER_UPLOAD_IS_IN_PROGRESS, "errorAnotherUploadIsInProgress"));
        this.register(createTemplateWithCoreMessage(STATUS__BAD_REQUEST, BASE__UNSUPPORTED_EXTENSION, "errorFileTypeIsIncorrect"));
        this.register(createTemplateWithCoreMessage(STATUS__NOT_FOUND, BASE__UNUSED_FILE_REMOVED_AFTER_TIMEOUT, "errorUnusedFileRemovedAfterTimeout"));
        this.register(createTemplateWithCoreMessage(STATUS__INTERNAL_SERVER_ERROR, BASE__ERROR_IN_FILE_UPLOAD, "errorInFileUpload"));
        this.register(createTemplateWithMessage(STATUS__FORBIDDEN, BASE__MISSING_CSRF_TOKEN, "ir.jame.portal.portalclient.PortalClientMessages", "errorMissingCsrfToken"));
        this.register(createTemplateWithMessage(STATUS__FORBIDDEN, BASE__INVALID_CSRF_TOKEN, "ir.jame.portal.portalclient.PortalClientMessages", "errorInvalidCsrfToken"));
        this.register(createTemplateWithCoreMessage(STATUS__BAD_REQUEST, BASE__REPORT_OUTPUT_FORMAT_IS_NOT_ALLOWED, "errorReportOutputFormatIsNotAllowed"));
        this.register(createTemplateWithCoreMessage(STATUS__BAD_REQUEST, BASE__ANOTHER_TRANSACTION_HAS_UPDATED_ENTITY, "errorAnotherTransactionHasUpdatedEntity"));
        this.register(createTemplateWithCoreMessage(STATUS__BAD_REQUEST, BASE__REQUEST_CONTAINS_UNAUTHORIZED_PARAMS, "errorRequestContainsUnauthorizedParams"));
        this.register(createTemplateWithCoreMessage(STATUS__NOT_FOUND, BASE__ENTITY_NOT_FOUND, "errorEntityNotFound"));
        this.register(createTemplateWithCoreMessage(STATUS__NOT_FOUND, BASE__ENTITY_NOT_FOUND_WITH_PROPERTY, "errorEntityNotFoundWithProperty"));
    }

    protected final void register(RemoteException remoteException) {
        if (typeToExceptionRegistry.containsKey(remoteException.getType())) {
            throw new IllegalArgumentException("A RemoteException with type=[" + remoteException.getType() + "] was registered previously. Use a new type.");
        } else {
            typeToExceptionRegistry.put(remoteException.getType(), remoteException);
        }
    }

    protected static RemoteException get(Integer type) {
        RemoteException remoteException = (RemoteException)typeToExceptionRegistry.get(type);
        if (remoteException == null) {
            throw new IllegalStateException("No exception was found with type=" + type);
        } else {
            return remoteException;
        }
    }

    public static RemoteException create(Integer type) {
        return create(type, (String)null);
    }

    public static RemoteException create(Integer type, String detail) {
        return create(type, detail, false, (Throwable)null);
    }

    public static RemoteException create(Integer type, boolean logOnServer, Throwable cause) {
        return create(type, (String)null, logOnServer, cause);
    }

    public static RemoteException create(Integer type, String detail, boolean logOnServer, Throwable cause) {
        RemoteException templateRemoteException = get(type);
        return new RemoteException(templateRemoteException.getStatus(), templateRemoteException.getType(), templateRemoteException.getTitle(), StringUtil.hasText(detail) ? detail : templateRemoteException.getDetail(), (Map)null, logOnServer, cause);
    }

    public static RemoteException createForbidden() {
        return create(STATUS__FORBIDDEN);
    }

    public static RemoteException createForbiddenWithPermission(AbstractPermission permission) {
        return createForbiddenWithPermission((AbstractPermission)permission, false, (Throwable)null);
    }

    public static RemoteException createForbiddenWithPermission(AbstractPermission permission, boolean logOnServer, Throwable cause) {
        return createForbiddenWithPermission(/*ServerSecurityUtil.getFullPermissionId(permission)*/"", logOnServer, cause);
    }

    public static RemoteException createForbiddenWithAnyPermission(AbstractPermission... permissions) {
        return createForbiddenWithAnyPermission(false, (Throwable)null, permissions);
    }

    public static RemoteException createForbiddenWithAnyPermission(boolean logOnServer, Throwable cause, AbstractPermission... permissions) {
        return createForbiddenWithPermission(StringUtil.convertCollectionToString((Collection) Arrays.asList(permissions).stream().map((permission) -> {
            return /*ServerSecurityUtil.getFullPermissionId(permission)*/"";
        }).collect(Collectors.toList()), " or "), logOnServer, cause);
    }

    public static RemoteException createForbiddenWithAllPermissions(AbstractPermission... permissions) {
        return createForbiddenWithAllPermissions(false, (Throwable)null, permissions);
    }

    public static RemoteException createForbiddenWithAllPermissions(boolean logOnServer, Throwable cause, AbstractPermission... permissions) {
        return createForbiddenWithPermission(StringUtil.convertCollectionToString((Collection)Arrays.asList(permissions).stream().map((permission) -> {
            return /*ServerSecurityUtil.getFullPermissionId(permission)*/"";
        }).collect(Collectors.toList()), " and "), logOnServer, cause);
    }

    public static RemoteException createForbiddenWithPermission(String fullPermission) {
        return createForbiddenWithPermission((String)fullPermission, false, (Throwable)null);
    }

    public static RemoteException createForbiddenWithPermission(String fullPermission, boolean logOnServer, Throwable cause) {
        RemoteException templateRemoteException = get(STATUS__FORBIDDEN);
        return new RemoteException(templateRemoteException.getStatus(), templateRemoteException.getType(), templateRemoteException.getTitle(), templateRemoteException.getTitle() + (StringUtil.hasText(fullPermission) ? " (" + fullPermission + ")" : ""), StringUtil.hasText(fullPermission) ? createExtendedProperties(Arrays.asList("permission"), Arrays.asList(fullPermission)) : null, logOnServer, cause);
    }

    public static RemoteException createWithMessageArgs(Integer type, Object... messageArgs) {
        return createWithMessageArgs(type, false, (Throwable)null, messageArgs);
    }

    public static RemoteException createWithMessageArgs(Integer type, boolean logOnServer, Throwable cause, Object... messageArgs) {
        RemoteException templateRemoteException = get(type);
        String title = templateRemoteException.getTitle();
        String detail = "";//ServerMessagesUtil.formatMessage(title, messageArgs);
        List<String> extendedPropertiesKeys = messageArgs != null && messageArgs.length > 0 ? (List) IntStream.range(0, messageArgs.length).mapToObj((num) -> {
            return "param" + num;
        }).collect(Collectors.toList()) : null;
        return new RemoteException(templateRemoteException.getStatus(), type, title, detail, createExtendedProperties(extendedPropertiesKeys, Arrays.asList(messageArgs)), logOnServer, cause);
    }

    protected static RemoteException createTemplateWithBaseMessage(Integer status, Integer type, String messageKey) {
        return createTemplateWithMessage(status, type, "ir.jame.core.i18n.BaseMessages", messageKey);
    }

    protected static RemoteException createTemplateWithCoreMessage(Integer status, Integer type, String messageKey) {
        return createTemplateWithMessage(status, type, "ir.jame.core.i18n.CoreMessages", messageKey);
    }

    protected static RemoteException createTemplateWithMessage(Integer status, Integer type, Class<?> transferableClass, String messageKey) {
        return createTemplateWithMessage(status, type, /*ServerMessagesUtil.getMessagesName(transferableClass)*/"", messageKey);
    }

    protected static RemoteException createTemplateWithMessage(Integer status, Integer type, String messagesName, String messageKey) {
        return new RemoteException(status, type, /*ServerMessagesUtil.getMessage(messagesName, messageKey, new Object[0]), ServerMessagesUtil.getMessage(messagesName, messageKey, new Object[0])*/"","");
    }

    protected static RemoteException createTemplate(Integer status, Integer type, String title) {
        return new RemoteException(status, type, title);
    }

    protected static LinkedHashMap<String, Object> createExtendedProperties(List<String> keys, List<Object> values) {
        LinkedHashMap<String, Object> extendedProperties = new LinkedHashMap();
        if (keys != null && values != null) {
            if (keys.size() != values.size()) {
                throw new IllegalArgumentException("'keys' and 'values' must have the same size.");
            } else {
                for(int i = 0; i < keys.size(); ++i) {
                    extendedProperties.put(keys.get(i), values.get(i));
                }

                return extendedProperties;
            }
        } else {
            return extendedProperties;
        }
    }
}
